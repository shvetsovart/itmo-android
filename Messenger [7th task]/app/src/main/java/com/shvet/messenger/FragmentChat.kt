package com.shvet.messenger

import android.app.Activity
import android.content.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.net.ConnectException
import java.util.concurrent.CopyOnWriteArrayList

class FragmentChat : Fragment() {
    private val messagesList = CopyOnWriteArrayList<Message>()
    private lateinit var chatView: View
    private var lastId = 0
    private var isRunning = false
    private lateinit var db: MessagesDao
    private var recyclerView: RecyclerView? = null
    private lateinit var attachButton: ImageButton
    private lateinit var sendButton: ImageButton
    private lateinit var textInput: EditText
    private lateinit var channelName: TextView
    private var scope = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = arguments
        if (args != null) {
            args.getString("channel")?.let {
                ChatApp.currentChannel = it
            }
        }
        return if (ChatApp.currentChannel.isNotBlank()) {
            inflater.inflate(R.layout.chat, container, false)
        } else {
            inflater.inflate(R.layout.empty_chat, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ChatApp.currentChannel.isNotBlank()) {
            db = AppDatabase.getDatabase(view.context)?.messageDao()!!
            chatView = view

            recyclerView = view.findViewById(R.id.recycler_view)
            attachButton = view.findViewById(R.id.attach_button)
            sendButton = view.findViewById(R.id.send_button)
            textInput = view.findViewById(R.id.message_input)

            channelName = view.findViewById(R.id.channel_name)
            channelName.text = ChatApp.currentChannel

            runChat()
            if (!isRunning) {
                isRunning = true
                scope.launch {
                    fetchMessages()
                }
            }
        }
    }

    private fun runChat() {
        attachButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            launchActivity.launch(intent)
        }

        sendButton.setOnClickListener {
            val messageText = textInput.text.toString()
            textInput.text.clear()
            scope.launch {
                ChatApp.messageApi.postMessageText(
                    Message(
                        true,
                        true,
                        0,
                        ChatApp.username,
                        ChatApp.currentChannel,
                        Data(Text(messageText), null),
                        System.currentTimeMillis()
                    )
                )
            }
        }
    }

    private val launchActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                scope.launch {
                    try {
                        sendMessageImage(it.data?.data)
                    } catch (e: ConnectException) {
                        e.printStackTrace()
                    }
                }
            }
        }

    private suspend fun sendMessageImage(uri: Uri?) = coroutineScope {
        if (uri != null) {
            runCatching {
                val file = getFileFromUri(uri)
                val to = ChatApp.currentChannel
                if (file != null) {
                    val json =
                        "{\"from\":\"${ChatApp.username}\",\"to\":\"$to\"}"
                    val requestFile = RequestBody
                        .create(MediaType.parse("multipart/form-data"), file)
                    val body = MultipartBody.Part
                        .createFormData("image", file.name, requestFile)
                    val requestJson = RequestBody
                        .create(MediaType.parse("multipart/form-data"), json)

                    ChatApp.messageApi.postMessageImage(
                        requestJson,
                        body
                    )
                    file.delete()
                }
            }
        }
    }

    private fun getFileFromUri(uri: Uri): File? {
        val bm = getBitmapFromUri(uri)
        val fileName = "${System.currentTimeMillis()}.png"
        if (bm != null) {
            return try {
                val file = File(chatView.context.cacheDir, fileName)
                file.createNewFile()
                val fileOutputStream = FileOutputStream(file)
                bm.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream)
                fileOutputStream.apply {
                    flush()
                    close()
                }
                file
            } catch (e: FileNotFoundException) {
                null
            } catch (e: IOException) {
                null
            }
        } else {
            return null
        }
    }

    private fun getBitmapFromUri(selectedFileUri: Uri): Bitmap? {
        var image: Bitmap? = null
        try {
            val parcelFileDescriptor =
                chatView
                    .context
                    .contentResolver
                    .openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor = parcelFileDescriptor!!.fileDescriptor
            image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    private suspend fun fetchMessagesFromNetwork() = coroutineScope {
        val newMessages = if (ChatApp.currentChannel.contains("channel")) {
            ChatApp
                .messageApi
                .fetchMessagesFromChannel(
                    ChatApp.currentChannel,
                    100,
                    lastId
                )
        } else {
            ChatApp
                .messageApi
                .fetchMessagesFromUser(
                    ChatApp.currentChannel,
                    100,
                    lastId
                ).filter { it.to == ChatApp.username }
        }

        if (newMessages.isNotEmpty()) {
            for (message in newMessages) {
                messagesList.add(message)
                lastId = message.id
                message.isTextMessage = message.data.Text != null
                message.isMine = message.from == ChatApp.username
                db.insert(
                    Entity(
                        message.id,
                        message.from,
                        message.to,
                        message.time,
                        message.isTextMessage,
                        message.data.Text?.text,
                        message.data.Image?.link,
                    )
                )
            }

            withContext(Dispatchers.Main) {
                updateRecyclerView()
            }
        }
    }

    private suspend fun fetchMessages() {
        messagesList.addAll(
            db.getMessagesFromChannel(ChatApp.currentChannel)
                .map { it.transformMessage() }
        )

        withContext(Dispatchers.Main) {
            if (recyclerView == null) {
                recyclerView = chatView.findViewById(R.id.recycler_view)
            }

            updateRecyclerView()
        }

        if (messagesList.isNotEmpty()) {
            lastId = messagesList.last().id
        }

        while (true) {
            try {
                fetchMessagesFromNetwork()
            } catch (e: ConnectException) {
                e.printStackTrace()
            }
            delay(2000)
        }
    }

    private fun updateRecyclerView() {
        recyclerView!!.apply {
            layoutManager = LinearLayoutManager(chatView.context).apply {
                stackFromEnd = true
            }
            adapter = MessagesAdapter(chatView.context, messagesList)
        }
        recyclerView!!.scrollToPosition(messagesList.size - 1)
    }

    private fun Entity.transformMessage(): Message {
        if (isText) {
            return Message(
                name == ChatApp.username,
                true,
                id,
                name,
                to,
                Data(Text(text!!), null),
                date
            )
        } else {
            return Message(
                name == ChatApp.username,
                false,
                id,
                name,
                to,
                Data(null, Image(imageLink!!, null)),
                date
            )
        }
    }

    private fun reloadFragment() {
        val fragment = activity?.supportFragmentManager?.findFragmentByTag(
            getString(R.string.chat_messages_container)
        )!!
        activity?.supportFragmentManager?.beginTransaction()!!
            .detach(fragment)
            .commit()
        activity?.supportFragmentManager?.beginTransaction()!!
            .attach(fragment)
            .commit()
    }

    fun selectChannel(channel: String) {
        ChatApp.currentChannel = channel
        isRunning = false
        recyclerView = null
        messagesList.clear()
        lastId = 0
        reloadFragment()
        /*
        channelName.text = channel
        scope.cancel()
        scope = CoroutineScope(Dispatchers.IO)
        isRunning = false
        messagesList.clear()
        scope.launch {
            fetchMessages()
        }

         */
    }
}
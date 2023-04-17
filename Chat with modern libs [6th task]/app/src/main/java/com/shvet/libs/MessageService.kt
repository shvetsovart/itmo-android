package com.shvet.libs

import android.app.Service
import android.content.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.*
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.coroutines.*
import okhttp3.*
import retrofit2.Response
import java.io.*
import java.net.*
import java.util.concurrent.CopyOnWriteArrayList

val mainHandler = Handler(Looper.getMainLooper())

lateinit var scope: CoroutineScope
lateinit var blockingScope: CoroutineScope

class MessageService : Service() {

    private var db: MessageDatabase? = null

    private var messageQueryIsRunning = false
    private var lastId = 0

    private val messageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                postMessage(intent)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        db = MessageDatabase.getDatabase(this@MessageService)
        scope = CoroutineScope(Dispatchers.IO)
        blockingScope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            getMessages()
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder {
        LocalBroadcastManager.getInstance(this).registerReceiver(
            messageReceiver,
            IntentFilter("SEND_MESSAGE")
        )
        return MessageBinder()
    }

    inner class MessageBinder : Binder() {
        fun getMessageService() = this@MessageService
    }

    private fun handleResponse(resp: Response<String>) {
        if (resp.code() >= 500) {
            showMessage(getString(R.string.errorServer))
            return
        }
        when (resp.code()) {
            404 -> showMessage(getString(R.string.errorNotFound))
            409 -> showMessage(getString(R.string.errorConflict))
            413 -> showMessage(getString(R.string.errorTooLarge))
            else -> showMessage(getString(R.string.requestSuccess))
        }
    }

    private fun showMessage(s: String) {
        mainHandler.post {
            Toast.makeText(
                applicationContext,
                s,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun postMessage(intent: Intent) {
        when (intent.getIntExtra("type", -1)) {
            -1 -> throw IllegalArgumentException("wtf?")
            0 -> scope.launch { postTextMessage(intent) }
            1 -> scope.launch { postImageMessage(intent) }
        }
    }

    private suspend fun postImageMessage(intent: Intent) {
        val from = intent.getStringExtra("from")!!
        val to = intent.getStringExtra("to")!!
        val uriString = intent.getStringExtra("uri")!!
        val uri = uriString.toUri()

        try {
            postImageMessageNetwork(from, to, uri)
        } catch (e: ConnectException) {
            e.printStackTrace()
        }
    }

    private fun uriToFile(uri: Uri): File? {
        val bm = uriToBitmap(uri)
        val fileName = "${System.currentTimeMillis()}"
        if (bm != null) {
            return try {
                val file = File(this@MessageService.cacheDir, fileName)
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

    private suspend fun postImageMessageNetwork(
        from: String,
        to: String,
        uri: Uri
    ) = coroutineScope {
        val file = uriToFile(uri)

        if (file != null) {
            val json = "{\"from\":\"$from\",\"to\":\"$to\"}"
            val requestFile = RequestBody
                .create(MediaType.parse("multipart/form-data"), file)
            val body = MultipartBody.Part
                .createFormData("image", file.name, requestFile)
            val requestJson = RequestBody
                .create(MediaType.parse("multipart/form-data"), json)

            val resp = MessengerApp.messageApi.postImageMessage(
                requestJson,
                body
            )

            file.delete()
            handleResponse(resp)
        }
    }

    private suspend fun postTextMessage(intent: Intent) {
        val text = intent.getStringExtra("text")!!
        val from = intent.getStringExtra("from")!!
        val to = intent.getStringExtra("to")!!
        val time = intent.getLongExtra("when", -1)
        try {
            postTextMessageNetwork(text, from, to, time)
        } catch (e: ConnectException) {
            e.printStackTrace()
        }
    }

    private suspend fun postTextMessageNetwork(
        text: String,
        from: String,
        to: String,
        time: Long
    ) = coroutineScope {

        val msg = Message(
            0,
            from,
            to,
            Data(Text(text), null),
            time
        )

        val resp = MessengerApp.messageApi.postTextMessage(
            msg
        )

        handleResponse(resp)
    }

    private fun uriToBitmap(selectedFileUri: Uri): Bitmap? {
        var image: Bitmap? = null
        try {
            val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor = parcelFileDescriptor!!.fileDescriptor
            image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    private suspend fun getMessages() {
        if (!messageQueryIsRunning) {
            messageQueryIsRunning = true
            Log.i("BEBRA_MOTIONS", "i started this thing")
            while (true) {
                try {
                    retrieveFromNetwork()
                } catch (e: ConnectException) {
                    e.printStackTrace()
                }
                delay(2000)
            }
        }
    }

    private suspend fun retrieveFromNetwork() = coroutineScope {
        if (db!!.messageDao().getAll().isNotEmpty() && messageList.isEmpty()) {
            messageList.addAll(db!!.messageDao().getAll().map{tableDataConverter(it)})
            LocalBroadcastManager.getInstance(this@MessageService)
                .sendBroadcast(
                    Intent("NEW_MESSAGES")
                        .putExtra("mode", 0)
                )
            lastId = messageList.last().id
        }

        val newMessages = if (messageList.isEmpty()) {
            MessengerApp.messageApi.getListMessages(100, 0)
                    as MutableList<Message>
        } else {
            MessengerApp.messageApi.getListMessages(100, lastId)
                    as MutableList<Message>
        }

        if (newMessages.isNotEmpty()) {
            for (m in newMessages) {
                if (m.data.Text != null) {
                    writeToTable(m, false)
                } else {
                    writeToTable(m, true)
                }
            }

            messageList.addAll(newMessages)
            lastId = messageList.last().id
            mainHandler.post {
                LocalBroadcastManager.getInstance(this@MessageService)
                    .sendBroadcast(
                        Intent("NEW_MESSAGES")
                            .putExtra("mode", 0)
                    )
            }
        }

        Log.i("BEBRA_MOTIONS", "last message is ${messageList.last()}")
    }

    private fun writeToTable(msg: Message, isImage: Boolean) {
        if (!isImage) {
            val tableMessage = TableMessage(
                msg.id,
                msg.from,
                msg.to,
                msg.data.Text!!.text,
                false,
                msg.time
            )
            db!!.messageDao().insertMessages(tableMessage)
        } else {
            val tableMessage = TableMessage(
                msg.id,
                msg.from,
                msg.to,
                msg.data.Image!!.link,
                true,
                msg.time
            )
            db!!.messageDao().insertMessages(tableMessage)
        }
    }

    private fun tableDataConverter(tableMessage: TableMessage): Message {
        if (tableMessage.image) {
            return Message(
                tableMessage.id,
                tableMessage.from,
                tableMessage.to,
                Data(null, Image(tableMessage.text, null)),
                tableMessage.time
            )
        } else {
            return Message(
                tableMessage.id,
                tableMessage.from,
                tableMessage.to,
                Data(Text(tableMessage.text), null),
                tableMessage.time
            )
        }
    }
}
package com.shvet.network

import android.app.Service
import android.content.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.beust.klaxon.Converter
import com.beust.klaxon.Json
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.*
import java.net.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.math.ceil

val mainHandler = Handler(Looper.getMainLooper())

class MessageService : Service() {

    var db: MessageDatabase? = null

    private val crlf = "\r\n"

    private val maxImageWidth = 300
    private val maxImageHeight = 300

    private val unprocessedImages = CopyOnWriteArrayList<Int>()
    private var isDelayedImageProcessingRunning = false

    data class JsonTextMessage(
        @Json(index = 1) val from: String,
        @Json(index = 2) val to: String,
        @Json(index = 3) val data: Text,
        @Json(index = 4) val time: Long
    )

    data class Text(val text: String)

    private val textMessageConverter = object : Converter {
        override fun canConvert(cls: Class<*>) = cls == Text::class.java

        override fun fromJson(jv: JsonValue): Any? {
            return null
        }

        override fun toJson(value: Any) = """{"Text" : {"text" : "${(value as Text).text}"}}"""

    }

    private var messageQueryIsRunning = false
    private var lastId = 0

    private val messageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("THREAD_ISSUES", "you asked me to post a message")
            if (intent != null) {
                postMessage(intent)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        db = MessageDatabase.getDatabase(this@MessageService)
        getMessages()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.i("THREAD_ISSUES", "bound")
        LocalBroadcastManager.getInstance(this).registerReceiver(
            messageReceiver, IntentFilter("SEND_MESSAGE")
        )
        return MessageBinder()
    }

    inner class MessageBinder : Binder() {
        fun getMessageService() = this@MessageService
    }

    private fun postMessage(intent: Intent) {
        when (intent.getIntExtra("type", -1)) {
            -1 -> throw IllegalArgumentException("unknown type of message")
            0 -> postTextMessage(intent)
            1 -> postImageMessage(intent)
        }
    }

    private fun postTextMessage(intent: Intent) {
        Thread {
            Log.i("THREAD_ISSUES", "I am in thread now")
            val text = intent.getStringExtra("text")!!
            val from = intent.getStringExtra("from")!!
            val to = intent.getStringExtra("to")!!
            val time = intent.getLongExtra("when", -1)
            val messageText = Text(text)

            val url = URL("http://213.189.221.170:8008/1ch")

            try {
                val connection = url.openConnection() as HttpURLConnection
                connection.doOutput = true
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")
                connection.connect()
                val messageToPost = JsonTextMessage(from, to, messageText, time)
                val messageJson =
                    Klaxon().converter(textMessageConverter).toJsonString(messageToPost)
                Log.i("SERVICE_ISSUES", "message to post is $messageJson")
                connection.outputStream.write(messageJson.toByteArray())
                Log.i("SERVICE_ISSUES", "server response is ${connection.responseMessage}")
                connection.disconnect()
            } catch (e: ConnectException) {
                Log.i("SERVICE_ISSUES", "Connect Exception")
            }
        }.start()
    }

    private fun postImageMessage(intent: Intent) {
        Thread {
            val imageUriString = intent.getStringExtra("uri")!!
            val from = intent.getStringExtra("from")!!

            val imageUri = imageUriString.toUri()
            val imageBitmap = uriToBitmap(imageUri)!!

            val fileName = "${System.currentTimeMillis()}" + contentResolver.getFileName(imageUri)

            val url = URL("http://213.189.221.170:8008/1ch")

            try {
                val connection = url.openConnection() as HttpURLConnection
                connection.doOutput = true
                connection.doInput = true
                connection.requestMethod = "POST"
                val boundary = MultipartTool.generateBoundary()
                connection.setRequestProperty(
                    "Content-Type", "multipart/form-data; boundary=$boundary"
                )

                val json = "{\"from\":\"${from}\"}"

                val image = File(this@MessageService.cacheDir, fileName)
                image.createNewFile()
                try {
                    val fileOutputStream = FileOutputStream(image)
                    imageBitmap.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream)
                    fileOutputStream.apply {
                        flush()
                        close()
                    }
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                val outputStream = connection.outputStream
                val osWriter = OutputStreamWriter(outputStream)
                outputStream.use {
                    osWriter.use {
                        with(it) {
                            append("--").append(boundary).append(crlf)
                            append("Content-Disposition: form-data; name=\"json\"").append(crlf)
                            append("Content-Type: application/json; charset=utf-8").append(crlf)
                            append(crlf)
                            append(json).append(crlf)
                            flush()
                            appendFile(image, boundary, outputStream)
                            append(crlf)
                            append("--").append(boundary).append("--").append(crlf)
                        }
                    }
                }
                image.delete()
            } catch (e: ConnectException) {
                Log.i("SERVICE_ISSUES", "ConnectException")
            }

        }.start()
    }

    private fun OutputStreamWriter.appendFile(
        file: File,
        boundary: String,
        outputStream: OutputStream,
    ) {
        val contentType = URLConnection.guessContentTypeFromName(file.name)
        val fis = FileInputStream(file)
        fis.use {
            append("--").append(boundary).append(crlf)
            append("Content-Disposition: form-data; name=\"file\"; filename=\"${file.name}\"")
            append(crlf)
            append("Content-Type: $contentType").append(crlf)
            append("Content-Length: ${file.length()}").append(crlf)
            append("Content-Transfer-Encoding: binary").append(crlf)
            append(crlf)
            flush()

            val buffer = ByteArray(4096)
            var n: Int
            while (fis.read(buffer).also { n = it } != -1) {
                outputStream.write(buffer, 0, n)
            }
            outputStream.flush()
            append(crlf)
            flush()
        }
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

    private fun ContentResolver.getFileName(uri: Uri): String {
        var name = ""
        val cursor = query(uri, null, null, null, null)
        cursor?.use {
            it.moveToFirst()
            val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (index > -1) {
                name = cursor.getString(index)
            }
        }
        return name
    }

    private fun getMessages() {
        if (!messageQueryIsRunning) {
            updateMessageQuery.run()
            messageQueryIsRunning = true
        }
    }

    private val updateMessageQuery = object : Runnable {
        override fun run() {
            Thread {
                try {
                    if (db!!.messageDao().getAll().isNotEmpty() && messageList.isEmpty()) {
                        Log.i(
                            "DB_ISSUES", "size of table is ${
                                db!!.messageDao().getAll().size
                            }"
                        )
                        messageList.addAll(
                            db!!.messageDao().getAll().map { tableDataConverter(it) })
                        LocalBroadcastManager.getInstance(this@MessageService).sendBroadcast(
                            Intent("NEW_MESSAGES").putExtra("mode", 0)
                        )
                        lastId = messageList.last().id
                    }

                    val connection = if (messageList.isEmpty()) {
                        URL(
                            "http://213.189.221.170:8008/1ch?limit=1000"
                        ).openConnection() as HttpURLConnection
                    } else {
                        URL(
                            "http://213.189.221.170:8008/" + "1ch?limit=1000&lastKnownId=${lastId}"
                        ).openConnection() as HttpURLConnection
                    }

                    connection.doInput = true
                    connection.requestMethod = "GET"
                    connection.connect()

                    val response = connection.inputStream.bufferedReader().readText()
                    Log.i("SERVICE_ISSUES", "server response is ${connection.responseMessage}")
                    connection.inputStream.close()
                    connection.disconnect()

                    if (response != "[]") {
                        messageList.addAll(parseResponse(response))
                        LocalBroadcastManager.getInstance(this@MessageService).sendBroadcast(
                            Intent("NEW_MESSAGES").putExtra("mode", 0)
                        )
                        lastId = messageList.last().id
                    }

                    if (!isDelayedImageProcessingRunning) {
                        mainHandler.post {
                            Toast.makeText(
                                applicationContext, "Loading messages...", Toast.LENGTH_SHORT
                            ).show()
                        }
                        runDelayedImageProcessing.run()
                        isDelayedImageProcessingRunning = true
                    }
                } catch (e: ConnectException) {
                    e.printStackTrace()
                }
                mainHandler.postDelayed(this, 2000)
            }.start()
        }
    }

    private val runDelayedImageProcessing = Runnable {
        delayedImageProcessing()
    }

    private fun parseResponse(response: String): ArrayList<Message> {
        val list = arrayListOf<Message>()
        val jsonArray = JSONTokener(response).nextValue() as JSONArray
        for (i in 0 until jsonArray.length()) {
            val id = jsonArray.getJSONObject(i).getInt("id")
            val from = jsonArray.getJSONObject(i).getString("from")
            val to = jsonArray.getJSONObject(i).getString("to")
            val dataString = jsonArray.getJSONObject(i).getString("data")
            val dataObject = JSONTokener(dataString).nextValue() as JSONObject

            if (dataString.contains("Image")) {
                val time = jsonArray.getJSONObject(i).getLong("time")
                val msg = Message(
                    id, from, to, MsgData(
                        null, BitmapImage(
                            "", null
                        )
                    ), time
                )

                unprocessedImages.add(id)
                list.add(msg)
                writeToTable(msg, true)
            } else {
                val text = dataObject.getString("Text")
                val textJson = JSONTokener(text).nextValue() as JSONObject
                val textText = textJson.getString("text")
                val thisMsgData = MsgData(textText, null)
                val time = jsonArray.getJSONObject(i).getLong("time")
                val msg = Message(id, from, to, thisMsgData, time)
                list.add(msg)
                writeToTable(msg, false)
            }
        }
        return list
    }

    private fun delayedImageProcessing() {
        var k = 0
        while (unprocessedImages.isNotEmpty()) {
            val id = unprocessedImages.first()
            var bm: Bitmap? = null
            for (i in k until messageList.size) {
                if (messageList[i].id == id) {
                    for (f in cacheDir.listFiles()!!) {
                        if (f.name == "$id.png") {
                            val curFile = f.inputStream()

                            bm = BitmapFactory.decodeStream(curFile)
                            curFile.close()
                            break
                        }
                    }
                    if (bm == null) {
                        bm = launchImageLoader(id)
                    }
                    messageList[i].msgData = MsgData(
                        null, BitmapImage(
                            "", shrinkBitmap(bm)
                        )
                    )
                    break
                }
            }
            unprocessedImages.removeFirst()
            k++
        }

        mainHandler.post {
            LocalBroadcastManager.getInstance(this@MessageService).sendBroadcast(
                Intent("NEW_MESSAGES").putExtra("mode", 1)
            )
        }
        isDelayedImageProcessingRunning = false
    }

    private fun writeImageToCache(bm: Bitmap, name: String) {
        val f = File(cacheDir, "$name.png")
        f.createNewFile()
        val fos = FileOutputStream(f)
        bm.compress(Bitmap.CompressFormat.PNG, 0, fos)
        fos.apply { flush(); close() }
    }

    private fun writeToTable(msg: Message, isImage: Boolean) {
        if (!isImage) {
            val tableMessage = TableMessage(
                msg.id, msg.from, msg.to, msg.msgData.msgText!!, false, msg.time
            )
            db!!.messageDao().insertMessages(tableMessage)
        } else {
            val tableMessage = TableMessage(
                msg.id, msg.from, msg.to, "", true, msg.time
            )
            db!!.messageDao().insertMessages(tableMessage)
        }
    }


    private fun launchImageLoader(id: Int): Bitmap? {
        val il = ImageLoader(id, "thumb") {
            if (it != null) {
                writeImageToCache(it, id.toString())
            }
        }
        il.run()

        return il.bitmap
    }

    private fun tableDataConverter(tableMessage: TableMessage): Message {
        if (tableMessage.image) {
            unprocessedImages.add(tableMessage.id)
            return Message(
                tableMessage.id,
                tableMessage.from,
                tableMessage.to,
                MsgData(null, BitmapImage("", null)),
                tableMessage.time
            )
        } else {
            return Message(
                tableMessage.id,
                tableMessage.from,
                tableMessage.to,
                MsgData(tableMessage.text, null),
                tableMessage.time
            )
        }
    }

    private fun shrinkBitmap(bm: Bitmap?): Bitmap? {
        if (bm == null) {
            return null
        }
        var ratio = 1.0
        val iHeight = (maxImageHeight * resources.displayMetrics.density).toInt()
        val iWidth = (maxImageWidth * resources.displayMetrics.density).toInt()
        if (bm.height > iHeight || bm.width > iWidth) {
            ratio = if (bm.height > bm.width) {
                ceil(bm.height / iHeight.toDouble())
            } else {
                ceil(bm.width / iWidth.toDouble())
            }
        }
        return Bitmap.createScaledBitmap(
            bm, (bm.width / ratio).toInt(), (bm.height / ratio).toInt(), false
        )
    }
}
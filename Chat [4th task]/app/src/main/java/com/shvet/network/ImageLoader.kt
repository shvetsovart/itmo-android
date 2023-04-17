package com.shvet.network

import android.graphics.Bitmap
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.URL

class ImageLoader(
    private val id: Int,
    private val mode: String,
    private var onFinish: ((Bitmap?) -> (Unit))?
) : Runnable {
    @Volatile
    var bitmap: Bitmap? = null

    @Volatile
    var success: Boolean = true

    override fun run() {
        if (onFinish == null) return
        val connection =
            URL("http://213.189.221.170:8008/1ch?limit=1&lastKnownId=${id - 1}")
                .openConnection() as HttpURLConnection

        try {
            connection.doInput = true
            connection.requestMethod = "GET"
            connection.connect()

            val response = connection.inputStream.bufferedReader().readText()
            connection.inputStream.close()
            connection.disconnect()

            var imageLink = ""
            val jsonArray = JSONTokener(response).nextValue() as JSONArray

            // get image link
            for (i in 0 until jsonArray.length()) {
                val dataString = jsonArray.getJSONObject(i).getString("data")
                val dataObject = JSONTokener(dataString).nextValue() as JSONObject
                val imageObject = JSONTokener(
                    dataObject.getString("Image")
                ).nextValue() as JSONObject
                imageLink = imageObject.getString("link")
            }

            val imageGetter = ImageBitmapGetter(imageLink, mode)
            imageGetter.run()
            bitmap = imageGetter.bitmap

            onFinish?.invoke(bitmap)
        } catch (e: ConnectException) {
            success = false
        }
    }

    fun cancel() {
        bitmap?.recycle()
        onFinish = null
    }
}
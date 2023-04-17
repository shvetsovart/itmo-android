package com.shvet.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class ImageBitmapGetter(
    private val link: String,
    private val mode: String
) : Runnable {
    @Volatile
    var bitmap: Bitmap? = null

    override fun run() {
        val host = "http://213.189.221.170:8008/$mode/$link"
        try {
            val connection = URL(host).openConnection() as HttpURLConnection

            connection.doInput = true
            connection.requestMethod = "GET"
            connection.connect()

            val inputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)

            inputStream.close()
            connection.disconnect()
        } catch (ex: MalformedURLException) {
            ex.printStackTrace()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}
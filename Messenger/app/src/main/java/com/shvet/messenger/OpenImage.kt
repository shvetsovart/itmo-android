package com.shvet.messenger

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.shvet.messenger.ChatApp
import com.shvet.messenger.R
import com.squareup.picasso.Picasso

class OpenImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.image_full_res_layout)

        val image = findViewById<ImageView>(R.id.full_res_image)
        val link = intent.getStringExtra("link")

        Picasso.get()
            .load("${ChatApp.BASE_URL}/img/$link")
            .into(image)
    }
}
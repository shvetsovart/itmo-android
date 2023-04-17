package com.shvet.messenger

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


class MessagesAdapter(
    private val context: Context,
    private val messages: List<Message>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TEXT = 1
    val IMAGE = 2

    private val formatDate = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.ENGLISH)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageView = view.findViewById<LinearLayout>(R.id.message_view)!!
        val name = view.findViewById<TextView>(R.id.message_from)!!
        val text = view.findViewById<TextView>(R.id.message_text)!!
        val date = view.findViewById<TextView>(R.id.message_time)!!
    }

    class ViewHolderImage(view: View) : RecyclerView.ViewHolder(view) {
        val messageView = view.findViewById<ConstraintLayout>(R.id.image_view)!!
        val name = view.findViewById<TextView>(R.id.message_from)!!
        val image = view.findViewById<ImageView>(R.id.message_image)!!
        val date = view.findViewById<TextView>(R.id.message_time)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TEXT -> ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.message_layout, parent, false)
            )
            else -> {
                ViewHolderImage(
                    LayoutInflater.from(context)
                        .inflate(R.layout.image_message_layout, parent, false)
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when {
        messages[position].isTextMessage -> TEXT
        else -> IMAGE
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type: Int = getItemViewType(position)
        val message = messages[position]
        when (type) {
            TEXT -> {
                val holderView = holder as ViewHolder

                holderView.name.text = message.from
                holderView.text.text = message.data.Text!!.text
                holderView.date.text = formatDate.format(Date(message.time))

                if (message.isMine) {
                    holderView.name.setTextColor(Color.parseColor("#1b880f"))
                    holderView.text.setBackgroundResource(R.drawable.day_round_user_message)
                } else {
                    holderView.text.setBackgroundResource(R.drawable.day_round_message)
                }
            }
            IMAGE -> {
                val holderView = holder as ViewHolderImage
                holderView.image.setOnClickListener {
                    val intentStart = Intent(context, OpenImage::class.java)
                    intentStart.putExtra("link", message.data.Image!!.link)
                    context.startActivity(intentStart)
                }

                holderView.name.text = message.from
                holderView.date.text = formatDate.format(Date(message.time))

                if (message.isMine) {
                    holderView.name.setTextColor(Color.parseColor("#1b880f"))
                    holderView.image.setBackgroundResource(R.drawable.day_round_user_message)
                } else {
                    holderView.image.setBackgroundResource(R.drawable.day_round_message)
                }

                Picasso.get()
                    .load(ChatApp.BASE_URL + "/thumb/" + message.data.Image!!.link)
                    .into(holder.image)
            }
        }
    }
}
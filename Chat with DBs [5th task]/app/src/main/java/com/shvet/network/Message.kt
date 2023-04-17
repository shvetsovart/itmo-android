package com.shvet.network

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.concurrent.CopyOnWriteArrayList

data class Message(
    val id: Int,
    var from: String,
    var to: String,
    var msgData: MsgData,
    var time: Long
)

var messageList = CopyOnWriteArrayList<Message>()

data class MsgData(
    val msgText: String?,
    val bitmapImage: BitmapImage?
)

data class BitmapImage(
    val link: String,
    val bitmap: Bitmap?
)

const val username = "shvetsovart"

@Entity(tableName = "message_table")
data class TableMessage(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "from") val from: String,
    @ColumnInfo(name = "to") val to: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "image") val image: Boolean,
    @ColumnInfo(name = "time") val time: Long
)
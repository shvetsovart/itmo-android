package com.shvet.messenger

import androidx.room.*
import com.shvet.messenger.Channel
import com.shvet.messenger.Entity

@Dao
interface MessagesDao {

    @Query("SELECT * FROM AppDatabase WHERE `to` = :channel")
    suspend fun getMessagesFromChannel(channel: String): List<Entity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChannel(channel: Channel)

    @Query("SELECT * FROM Channels")
    suspend fun getAllChannels(): List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(element: Entity)

}
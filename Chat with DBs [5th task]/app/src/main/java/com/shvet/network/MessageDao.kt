package com.shvet.network

import androidx.room.*

@Dao
interface MessageDao {
    @Query("SELECT * FROM message_table")
    fun getAll() : List<TableMessage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMessages(vararg messages: TableMessage)
}
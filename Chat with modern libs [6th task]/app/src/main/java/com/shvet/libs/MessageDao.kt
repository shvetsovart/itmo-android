package com.shvet.libs

import androidx.room.*
import com.shvet.libs.TableMessage

@Dao
interface MessageDao {
    @Query("SELECT * FROM message_table")
    fun getAll() : List<TableMessage>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMessages(vararg messages: TableMessage)
}
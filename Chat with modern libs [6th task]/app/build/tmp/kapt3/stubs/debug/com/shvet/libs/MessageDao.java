package com.shvet.libs;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J!\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\b\"\u00020\u0004H\'\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/shvet/libs/MessageDao;", "", "getAll", "", "Lcom/shvet/libs/TableMessage;", "insertMessages", "", "messages", "", "([Lcom/shvet/libs/TableMessage;)V", "app_debug"})
public abstract interface MessageDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM message_table")
    public abstract java.util.List<com.shvet.libs.TableMessage> getAll();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertMessages(@org.jetbrains.annotations.NotNull()
    com.shvet.libs.TableMessage... messages);
}
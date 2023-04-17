package com.shvet.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\nH\u00c6\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f\u00a8\u0006\'"}, d2 = {"Lcom/shvet/network/Message;", "", "id", "", "from", "", "to", "msgData", "Lcom/shvet/network/MsgData;", "time", "", "(ILjava/lang/String;Ljava/lang/String;Lcom/shvet/network/MsgData;J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getId", "()I", "getMsgData", "()Lcom/shvet/network/MsgData;", "setMsgData", "(Lcom/shvet/network/MsgData;)V", "getTime", "()J", "setTime", "(J)V", "getTo", "setTo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Message {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String from;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String to;
    @org.jetbrains.annotations.NotNull()
    private com.shvet.network.MsgData msgData;
    private long time;
    
    @org.jetbrains.annotations.NotNull()
    public final com.shvet.network.Message copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to, @org.jetbrains.annotations.NotNull()
    com.shvet.network.MsgData msgData, long time) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Message(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to, @org.jetbrains.annotations.NotNull()
    com.shvet.network.MsgData msgData, long time) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFrom() {
        return null;
    }
    
    public final void setFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTo() {
        return null;
    }
    
    public final void setTo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shvet.network.MsgData component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shvet.network.MsgData getMsgData() {
        return null;
    }
    
    public final void setMsgData(@org.jetbrains.annotations.NotNull()
    com.shvet.network.MsgData p0) {
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
}
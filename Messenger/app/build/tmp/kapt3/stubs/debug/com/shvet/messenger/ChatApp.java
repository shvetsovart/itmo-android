package com.shvet.messenger;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/shvet/messenger/ChatApp;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class ChatApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.shvet.messenger.ChatApp.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String username = "shvetsovart";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "http://213.189.221.170:8008";
    private static com.shvet.messenger.ChatApp app;
    public static com.shvet.messenger.Api messageApi;
    public static com.squareup.moshi.Moshi moshi;
    public static com.shvet.messenger.MessagesDao db;
    public static java.lang.String currentChannel;
    
    public ChatApp() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/shvet/messenger/ChatApp$Companion;", "", "()V", "BASE_URL", "", "<set-?>", "Lcom/shvet/messenger/ChatApp;", "app", "getApp", "()Lcom/shvet/messenger/ChatApp;", "setApp", "(Lcom/shvet/messenger/ChatApp;)V", "currentChannel", "getCurrentChannel", "()Ljava/lang/String;", "setCurrentChannel", "(Ljava/lang/String;)V", "db", "Lcom/shvet/messenger/MessagesDao;", "getDb", "()Lcom/shvet/messenger/MessagesDao;", "setDb", "(Lcom/shvet/messenger/MessagesDao;)V", "messageApi", "Lcom/shvet/messenger/Api;", "getMessageApi", "()Lcom/shvet/messenger/Api;", "setMessageApi", "(Lcom/shvet/messenger/Api;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "username", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.messenger.ChatApp getApp() {
            return null;
        }
        
        private final void setApp(com.shvet.messenger.ChatApp p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.messenger.Api getMessageApi() {
            return null;
        }
        
        public final void setMessageApi(@org.jetbrains.annotations.NotNull()
        com.shvet.messenger.Api p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.squareup.moshi.Moshi getMoshi() {
            return null;
        }
        
        public final void setMoshi(@org.jetbrains.annotations.NotNull()
        com.squareup.moshi.Moshi p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.messenger.MessagesDao getDb() {
            return null;
        }
        
        public final void setDb(@org.jetbrains.annotations.NotNull()
        com.shvet.messenger.MessagesDao p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCurrentChannel() {
            return null;
        }
        
        public final void setCurrentChannel(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
    }
}
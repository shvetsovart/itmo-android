package com.shvet.libs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/shvet/libs/MessengerApp;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class MessengerApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.shvet.libs.MessengerApp.Companion Companion = null;
    private static com.shvet.libs.MessengerApp instance;
    public static com.shvet.libs.MessageApi messageApi;
    public static com.squareup.moshi.Moshi moshi;
    
    public MessengerApp() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/shvet/libs/MessengerApp$Companion;", "", "()V", "<set-?>", "Lcom/shvet/libs/MessengerApp;", "instance", "getInstance", "()Lcom/shvet/libs/MessengerApp;", "setInstance", "(Lcom/shvet/libs/MessengerApp;)V", "messageApi", "Lcom/shvet/libs/MessageApi;", "getMessageApi", "()Lcom/shvet/libs/MessageApi;", "setMessageApi", "(Lcom/shvet/libs/MessageApi;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.libs.MessengerApp getInstance() {
            return null;
        }
        
        private final void setInstance(com.shvet.libs.MessengerApp p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.libs.MessageApi getMessageApi() {
            return null;
        }
        
        public final void setMessageApi(@org.jetbrains.annotations.NotNull()
        com.shvet.libs.MessageApi p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.squareup.moshi.Moshi getMoshi() {
            return null;
        }
        
        public final void setMoshi(@org.jetbrains.annotations.NotNull()
        com.squareup.moshi.Moshi p0) {
        }
    }
}
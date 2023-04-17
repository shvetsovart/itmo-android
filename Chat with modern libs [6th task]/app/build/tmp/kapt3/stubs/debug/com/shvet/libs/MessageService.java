package com.shvet.libs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u000b\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0019\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0019\u0010\"\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ1\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0011\u0010(\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001fH\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/shvet/libs/MessageService;", "Landroid/app/Service;", "()V", "db", "Lcom/shvet/libs/MessageDatabase;", "lastId", "", "messageQueryIsRunning", "", "messageReceiver", "Landroid/content/BroadcastReceiver;", "getMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResponse", "resp", "Lretrofit2/Response;", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "postImageMessage", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postImageMessageNetwork", "from", "to", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postMessage", "postTextMessage", "postTextMessageNetwork", "text", "time", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveFromNetwork", "showMessage", "s", "tableDataConverter", "Lcom/shvet/libs/Message;", "tableMessage", "Lcom/shvet/libs/TableMessage;", "uriToBitmap", "Landroid/graphics/Bitmap;", "selectedFileUri", "uriToFile", "Ljava/io/File;", "writeToTable", "msg", "isImage", "MessageBinder", "app_debug"})
public final class MessageService extends android.app.Service {
    private com.shvet.libs.MessageDatabase db;
    private boolean messageQueryIsRunning = false;
    private int lastId = 0;
    private final android.content.BroadcastReceiver messageReceiver = null;
    
    public MessageService() {
        super();
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    private final void handleResponse(retrofit2.Response<java.lang.String> resp) {
    }
    
    private final void showMessage(java.lang.String s) {
    }
    
    private final void postMessage(android.content.Intent intent) {
    }
    
    private final java.lang.Object postImageMessage(android.content.Intent intent, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.io.File uriToFile(android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.Object postImageMessageNetwork(java.lang.String from, java.lang.String to, android.net.Uri uri, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object postTextMessage(android.content.Intent intent, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object postTextMessageNetwork(java.lang.String text, java.lang.String from, java.lang.String to, long time, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final android.graphics.Bitmap uriToBitmap(android.net.Uri selectedFileUri) {
        return null;
    }
    
    private final java.lang.Object getMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object retrieveFromNetwork(kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    private final void writeToTable(com.shvet.libs.Message msg, boolean isImage) {
    }
    
    private final com.shvet.libs.Message tableDataConverter(com.shvet.libs.TableMessage tableMessage) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/shvet/libs/MessageService$MessageBinder;", "Landroid/os/Binder;", "(Lcom/shvet/libs/MessageService;)V", "getMessageService", "Lcom/shvet/libs/MessageService;", "app_debug"})
    public final class MessageBinder extends android.os.Binder {
        
        public MessageBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.libs.MessageService getMessageService() {
            return null;
        }
    }
}
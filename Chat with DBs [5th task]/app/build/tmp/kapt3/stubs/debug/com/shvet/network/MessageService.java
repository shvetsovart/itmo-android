package com.shvet.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003GHIB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\"\u0010%\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\'\u001a\u00020\u000eH\u0016J \u0010(\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u00100\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u001f2\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\fH\u0002J$\u0010=\u001a\u00020\u001c*\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0002J\u0014\u0010D\u001a\u00020\u0004*\u00020E2\u0006\u0010F\u001a\u000207H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/shvet/network/MessageService;", "Landroid/app/Service;", "()V", "crlf", "", "db", "Lcom/shvet/network/MessageDatabase;", "getDb", "()Lcom/shvet/network/MessageDatabase;", "setDb", "(Lcom/shvet/network/MessageDatabase;)V", "isDelayedImageProcessingRunning", "", "lastId", "", "maxImageHeight", "maxImageWidth", "messageQueryIsRunning", "messageReceiver", "Landroid/content/BroadcastReceiver;", "runDelayedImageProcessing", "Ljava/lang/Runnable;", "textMessageConverter", "Lcom/beust/klaxon/Converter;", "unprocessedImages", "", "updateMessageQuery", "delayedImageProcessing", "", "getMessages", "launchImageLoader", "Landroid/graphics/Bitmap;", "id", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "parseResponse", "Ljava/util/ArrayList;", "Lcom/shvet/network/Message;", "Lkotlin/collections/ArrayList;", "response", "postImageMessage", "postMessage", "postTextMessage", "shrinkBitmap", "bm", "tableDataConverter", "tableMessage", "Lcom/shvet/network/TableMessage;", "uriToBitmap", "selectedFileUri", "Landroid/net/Uri;", "writeImageToCache", "name", "writeToTable", "msg", "isImage", "appendFile", "Ljava/io/OutputStreamWriter;", "file", "Ljava/io/File;", "boundary", "outputStream", "Ljava/io/OutputStream;", "getFileName", "Landroid/content/ContentResolver;", "uri", "JsonTextMessage", "MessageBinder", "Text", "app_debug"})
public final class MessageService extends android.app.Service {
    @org.jetbrains.annotations.Nullable()
    private com.shvet.network.MessageDatabase db;
    private final java.lang.String crlf = "\r\n";
    private final int maxImageWidth = 300;
    private final int maxImageHeight = 300;
    private final java.util.List<java.lang.Integer> unprocessedImages = null;
    private boolean isDelayedImageProcessingRunning = false;
    private final com.beust.klaxon.Converter textMessageConverter = null;
    private boolean messageQueryIsRunning = false;
    private int lastId = 0;
    private final android.content.BroadcastReceiver messageReceiver = null;
    private final java.lang.Runnable updateMessageQuery = null;
    private final java.lang.Runnable runDelayedImageProcessing = null;
    
    public MessageService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.network.MessageDatabase getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.Nullable()
    com.shvet.network.MessageDatabase p0) {
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
    
    private final void postMessage(android.content.Intent intent) {
    }
    
    private final void postTextMessage(android.content.Intent intent) {
    }
    
    private final void postImageMessage(android.content.Intent intent) {
    }
    
    private final void appendFile(java.io.OutputStreamWriter $this$appendFile, java.io.File file, java.lang.String boundary, java.io.OutputStream outputStream) {
    }
    
    private final android.graphics.Bitmap uriToBitmap(android.net.Uri selectedFileUri) {
        return null;
    }
    
    private final java.lang.String getFileName(android.content.ContentResolver $this$getFileName, android.net.Uri uri) {
        return null;
    }
    
    private final void getMessages() {
    }
    
    private final java.util.ArrayList<com.shvet.network.Message> parseResponse(java.lang.String response) {
        return null;
    }
    
    private final void delayedImageProcessing() {
    }
    
    private final void writeImageToCache(android.graphics.Bitmap bm, java.lang.String name) {
    }
    
    private final void writeToTable(com.shvet.network.Message msg, boolean isImage) {
    }
    
    private final android.graphics.Bitmap launchImageLoader(int id) {
        return null;
    }
    
    private final com.shvet.network.Message tableDataConverter(com.shvet.network.TableMessage tableMessage) {
        return null;
    }
    
    private final android.graphics.Bitmap shrinkBitmap(android.graphics.Bitmap bm) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/shvet/network/MessageService$JsonTextMessage;", "", "from", "", "to", "data", "Lcom/shvet/network/MessageService$Text;", "time", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/shvet/network/MessageService$Text;J)V", "getData$annotations", "()V", "getData", "()Lcom/shvet/network/MessageService$Text;", "getFrom$annotations", "getFrom", "()Ljava/lang/String;", "getTime$annotations", "getTime", "()J", "getTo$annotations", "getTo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class JsonTextMessage {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String from = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String to = null;
        @org.jetbrains.annotations.NotNull()
        private final com.shvet.network.MessageService.Text data = null;
        private final long time = 0L;
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.network.MessageService.JsonTextMessage copy(@org.jetbrains.annotations.NotNull()
        java.lang.String from, @org.jetbrains.annotations.NotNull()
        java.lang.String to, @org.jetbrains.annotations.NotNull()
        com.shvet.network.MessageService.Text data, long time) {
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
        
        public JsonTextMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String from, @org.jetbrains.annotations.NotNull()
        java.lang.String to, @org.jetbrains.annotations.NotNull()
        com.shvet.network.MessageService.Text data, long time) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFrom() {
            return null;
        }
        
        @com.beust.klaxon.Json(index = 1L)
        @java.lang.Deprecated()
        public static void getFrom$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTo() {
            return null;
        }
        
        @com.beust.klaxon.Json(index = 2L)
        @java.lang.Deprecated()
        public static void getTo$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.network.MessageService.Text component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.network.MessageService.Text getData() {
            return null;
        }
        
        @com.beust.klaxon.Json(index = 3L)
        @java.lang.Deprecated()
        public static void getData$annotations() {
        }
        
        public final long component4() {
            return 0L;
        }
        
        public final long getTime() {
            return 0L;
        }
        
        @com.beust.klaxon.Json(index = 4L)
        @java.lang.Deprecated()
        public static void getTime$annotations() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/shvet/network/MessageService$Text;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class Text {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String text = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.network.MessageService.Text copy(@org.jetbrains.annotations.NotNull()
        java.lang.String text) {
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
        
        public Text(@org.jetbrains.annotations.NotNull()
        java.lang.String text) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/shvet/network/MessageService$MessageBinder;", "Landroid/os/Binder;", "(Lcom/shvet/network/MessageService;)V", "getMessageService", "Lcom/shvet/network/MessageService;", "app_debug"})
    public final class MessageBinder extends android.os.Binder {
        
        public MessageBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.shvet.network.MessageService getMessageService() {
            return null;
        }
    }
}
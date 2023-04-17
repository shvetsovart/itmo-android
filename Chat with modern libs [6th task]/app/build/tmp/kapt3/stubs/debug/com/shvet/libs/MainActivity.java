package com.shvet.libs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0014J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020(H\u0014J\b\u0010,\u001a\u00020&H\u0014J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/shvet/libs/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "attachFileButton", "Landroid/widget/ImageButton;", "boundServiceConnection", "Landroid/content/ServiceConnection;", "isBound", "", "()Z", "setBound", "(Z)V", "messageInput", "Landroid/widget/EditText;", "messageReceiver", "Landroid/content/BroadcastReceiver;", "messageService", "Lcom/shvet/libs/MessageService;", "getMessageService", "()Lcom/shvet/libs/MessageService;", "setMessageService", "(Lcom/shvet/libs/MessageService;)V", "recyclerPosition", "", "getRecyclerPosition", "()I", "setRecyclerPosition", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sendButton", "sendFileActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "viewManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRestoreInstanceState", "onSaveInstanceState", "outState", "onStart", "onStop", "time", "", "updateRecyclerView", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.ImageButton sendButton;
    private android.widget.EditText messageInput;
    private android.widget.ImageButton attachFileButton;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private androidx.recyclerview.widget.LinearLayoutManager viewManager;
    @org.jetbrains.annotations.Nullable()
    private com.shvet.libs.MessageService messageService;
    private boolean isBound = false;
    private int recyclerPosition = 0;
    private final android.content.ServiceConnection boundServiceConnection = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.shvet.libs.MainActivity.Companion Companion = null;
    private static final java.lang.String RECYCLER_POSITION = "messenger.MainActivity.recyclerPosition";
    private final android.content.BroadcastReceiver messageReceiver = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> sendFileActivity = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.libs.MessageService getMessageService() {
        return null;
    }
    
    public final void setMessageService(@org.jetbrains.annotations.Nullable()
    com.shvet.libs.MessageService p0) {
    }
    
    public final boolean isBound() {
        return false;
    }
    
    public final void setBound(boolean p0) {
    }
    
    public final int getRecyclerPosition() {
        return 0;
    }
    
    public final void setRecyclerPosition(int p0) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.LinearLayoutManager viewManager) {
    }
    
    private final long time() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/shvet/libs/MainActivity$Companion;", "", "()V", "RECYCLER_POSITION", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
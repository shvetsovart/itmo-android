package com.shvet.messenger;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u001d\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020$H\u0002J&\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\u001a\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00102\u001a\u00020\u001eH\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206J\u001b\u00107\u001a\u00020\u001e2\b\u0010\'\u001a\u0004\u0018\u00010$H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J\b\u00109\u001a\u00020\u001eH\u0002J\f\u0010:\u001a\u00020\u0015*\u00020;H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/shvet/messenger/FragmentChat;", "Landroidx/fragment/app/Fragment;", "()V", "attachButton", "Landroid/widget/ImageButton;", "channelName", "Landroid/widget/TextView;", "chatView", "Landroid/view/View;", "db", "Lcom/shvet/messenger/MessagesDao;", "isRunning", "", "lastId", "", "launchActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "messagesList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/shvet/messenger/Message;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendButton", "textInput", "Landroid/widget/EditText;", "fetchMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchMessagesFromNetwork", "getBitmapFromUri", "Landroid/graphics/Bitmap;", "selectedFileUri", "Landroid/net/Uri;", "getFileFromUri", "Ljava/io/File;", "uri", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "reloadFragment", "runChat", "selectChannel", "channel", "", "sendMessageImage", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecyclerView", "transformMessage", "Lcom/shvet/messenger/Entity;", "app_debug"})
public final class FragmentChat extends androidx.fragment.app.Fragment {
    private final java.util.concurrent.CopyOnWriteArrayList<com.shvet.messenger.Message> messagesList = null;
    private android.view.View chatView;
    private int lastId = 0;
    private boolean isRunning = false;
    private com.shvet.messenger.MessagesDao db;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ImageButton attachButton;
    private android.widget.ImageButton sendButton;
    private android.widget.EditText textInput;
    private android.widget.TextView channelName;
    private kotlinx.coroutines.CoroutineScope scope;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchActivity = null;
    
    public FragmentChat() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void runChat() {
    }
    
    private final java.lang.Object sendMessageImage(android.net.Uri uri, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.io.File getFileFromUri(android.net.Uri uri) {
        return null;
    }
    
    private final android.graphics.Bitmap getBitmapFromUri(android.net.Uri selectedFileUri) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final java.lang.Object fetchMessagesFromNetwork(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object fetchMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void updateRecyclerView() {
    }
    
    private final com.shvet.messenger.Message transformMessage(com.shvet.messenger.Entity $this$transformMessage) {
        return null;
    }
    
    private final void reloadFragment() {
    }
    
    public final void selectChannel(@org.jetbrains.annotations.NotNull()
    java.lang.String channel) {
    }
}
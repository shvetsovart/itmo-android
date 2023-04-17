package com.shvet.messenger;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J&\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0019\u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/shvet/messenger/FragmentListChat;", "Landroidx/fragment/app/Fragment;", "()V", "addButton", "Landroid/widget/ImageButton;", "channels", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "db", "Lcom/shvet/messenger/MessagesDao;", "isRunning", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getChannels", "", "view", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelsFromNetwork", "loadChannelsFromDb", "Lkotlinx/coroutines/Job;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSaveInstanceState", "outState", "onViewCreated", "onViewStateRestored", "showChannels", "Companion", "app_debug"})
public final class FragmentListChat extends androidx.fragment.app.Fragment {
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private boolean isRunning = false;
    private com.shvet.messenger.MessagesDao db;
    private android.widget.ImageButton addButton;
    private final java.util.concurrent.CopyOnWriteArraySet<java.lang.String> channels = null;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.NotNull()
    public static final com.shvet.messenger.FragmentListChat.Companion Companion = null;
    private static final java.lang.String IS_RUNNING = "com.shvet.messenger.isRunning";
    
    public FragmentListChat() {
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
    
    private final java.lang.Object getChannels(android.view.View view, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getChannelsFromNetwork(android.view.View view, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.RecyclerView> continuation) {
        return null;
    }
    
    private final java.lang.Object loadChannelsFromDb(android.view.View view, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
        return null;
    }
    
    private final java.lang.Object showChannels(android.view.View view, kotlin.coroutines.Continuation<? super androidx.recyclerview.widget.RecyclerView> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    public void onViewStateRestored(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/shvet/messenger/FragmentListChat$Companion;", "", "()V", "IS_RUNNING", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
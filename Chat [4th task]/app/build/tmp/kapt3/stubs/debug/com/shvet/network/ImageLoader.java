package com.shvet.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\tH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/shvet/network/ImageLoader;", "Ljava/lang/Runnable;", "id", "", "mode", "", "onFinish", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "run", "app_debug"})
public final class ImageLoader implements java.lang.Runnable {
    private final int id = 0;
    private final java.lang.String mode = null;
    private kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onFinish;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Volatile()
    private volatile android.graphics.Bitmap bitmap;
    @kotlin.jvm.Volatile()
    private volatile boolean success = true;
    
    public ImageLoader(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String mode, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onFinish) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getBitmap() {
        return null;
    }
    
    public final void setBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    public final void setSuccess(boolean p0) {
    }
    
    @java.lang.Override()
    public void run() {
    }
}
package com.shvet.libs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/shvet/libs/Data;", "", "Text", "Lcom/shvet/libs/Text;", "Image", "Lcom/shvet/libs/Image;", "(Lcom/shvet/libs/Text;Lcom/shvet/libs/Image;)V", "getImage", "()Lcom/shvet/libs/Image;", "getText", "()Lcom/shvet/libs/Text;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class Data {
    @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "Text")
    private final com.shvet.libs.Text Text = null;
    @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "Image")
    private final com.shvet.libs.Image Image = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.shvet.libs.Data copy(@org.jetbrains.annotations.Nullable()
    com.shvet.libs.Text Text, @org.jetbrains.annotations.Nullable()
    com.shvet.libs.Image Image) {
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
    
    public Data() {
        super();
    }
    
    public Data(@org.jetbrains.annotations.Nullable()
    com.shvet.libs.Text Text, @org.jetbrains.annotations.Nullable()
    com.shvet.libs.Image Image) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.libs.Text component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.libs.Text getText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.libs.Image component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shvet.libs.Image getImage() {
        return null;
    }
}
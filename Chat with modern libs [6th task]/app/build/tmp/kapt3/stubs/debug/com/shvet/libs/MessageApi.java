package com.shvet.libs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0012\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/shvet/libs/MessageApi;", "", "getListMessages", "", "Lcom/shvet/libs/Message;", "limit", "", "lastKnownId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postImageMessage", "Lretrofit2/Response;", "", "json", "Lokhttp3/RequestBody;", "image", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postTextMessage", "message", "(Lcom/shvet/libs/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MessageApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/1ch")
    public abstract java.lang.Object getListMessages(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "lastKnownId")
    int lastKnownId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.shvet.libs.Message>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/1ch")
    public abstract java.lang.Object postTextMessage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.shvet.libs.Message message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/1ch")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object postImageMessage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "json")
    okhttp3.RequestBody json, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> continuation);
}
package com.jerry.androidstudy.okhttp;

public interface IHttpRequest {
    void setUrl(String url);
    void setData(byte[] data);
    void setListener(CallbackListener callbackListener);
    void excute();
}

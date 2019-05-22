package com.jerry.androidstudy.okhttp;

import com.alibaba.fastjson.JSON;

public class HttpTask<T> implements Runnable{
    public HttpTask(String url,T requestData,IHttpRequest httpRequest,CallbackListener listener){
        httpRequest.setUrl(url);
        httpRequest.setListener(listener);
        JSON.toJSONString(requestData);
    }

    @Override
    public void run() {

    }
}

package com.jerry.androidstudy.okhttp;

import java.io.InputStream;

public interface CallbackListener {
    void onSuccess(InputStream inputStream);
    void onFailure();
}

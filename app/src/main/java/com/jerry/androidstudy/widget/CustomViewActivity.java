package com.jerry.androidstudy.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jerry.androidstudy.R;

public class CustomViewActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level){
            case TRIM_MEMORY_UI_HIDDEN:
                break;
        }
    }
}

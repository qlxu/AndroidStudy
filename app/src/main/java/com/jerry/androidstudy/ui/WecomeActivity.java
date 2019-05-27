package com.jerry.androidstudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jerry.androidstudy.R;
import com.jerry.androidstudy.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

public class WecomeActivity extends AppCompatActivity {

    private BGABanner mContentBanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecome);

        mContentBanner = findViewById(R.id.banner_guide_content);

        List<View> views = new ArrayList<>();
        views.add(View.inflate(this, R.layout.parallax_view_1, null));
        views.add(View.inflate(this, R.layout.parallax_view_2, null));
        views.add(View.inflate(this, R.layout.parallax_view_3, null));
        mContentBanner.setData(views);
    }

}

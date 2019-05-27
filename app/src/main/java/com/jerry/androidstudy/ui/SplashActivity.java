package com.jerry.androidstudy.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jerry.androidstudy.R;
import com.jerry.androidstudy.util.ScreenUtils;
import com.prolificinteractive.parallaxpager.ParallaxContainer;
import com.prolificinteractive.parallaxpager.ParallaxContextWrapper;
import com.zhy.autolayout.AutoLayoutActivity;

public class SplashActivity extends AppCompatActivity {
    private ParallaxContainer parallaxContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        parallaxContainer = findViewById(R.id.parallax_container);

//        if (ScreenUtils.isPortrait()) {
//            ScreenUtils.adaptScreen4VerticalSlide(this, 360);
//        } else {
//            ScreenUtils.adaptScreen4HorizontalSlide(this, 360);
//        }
//        ScreenUtils.adaptScreen4HorizontalSlide(this, 1080);

        parallaxContainer.setLooping(false);
        // wrap the inflater and inflate children with custom attributes
        parallaxContainer.setupChildren(getLayoutInflater(),
                R.layout.parallax_view_1_test,
                R.layout.parallax_view_2_test,
                R.layout.parallax_view_3_test);
        parallaxContainer.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        findViewById(R.id.btnTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"succss",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new ParallaxContextWrapper(newBase));
    }

    @Override
    protected void onDestroy() {
//        ScreenUtils.cancelAdaptScreen(this);
        super.onDestroy();
    }
}

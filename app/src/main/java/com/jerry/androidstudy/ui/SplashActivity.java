package com.jerry.androidstudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jerry.androidstudy.R;
import com.prolificinteractive.parallaxpager.ParallaxContainer;

public class SplashActivity extends AppCompatActivity {
    private ParallaxContainer parallaxContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        parallaxContainer = findViewById(R.id.parallax_container);

        parallaxContainer.setLooping(false);
        // wrap the inflater and inflate children with custom attributes
        parallaxContainer.setupChildren(getLayoutInflater(),
                R.layout.parallax_view_1,
                R.layout.parallax_view_2,
                R.layout.parallax_view_3);
    }
}

package com.jerry.androidstudy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jerry.androidstudy.databinding.DataBingdingActivity;
import com.jerry.androidstudy.javareview.Dog;
import com.jerry.androidstudy.service.HandlerThreadActivity;
import com.jerry.androidstudy.service.MyService;
import com.jerry.androidstudy.ui.ClearEditViewTestActivity;
import com.jerry.androidstudy.ui.ShowGifActivity;
import com.jerry.androidstudy.ui.SplashActivity;
import com.jerry.androidstudy.ui.WecomeActivity;
import com.jerry.androidstudy.widget.CustomViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        findViewById(R.id.handlerThreadTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HandlerThreadActivity.class));
            }
        });

        findViewById(R.id.serviceTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
//                startService(intent);
                bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
//                        MyService.MyBind myBind = (MyService.MyBind) service;
//                        MyService myService = myBind.getService();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                }, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.customViewTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomViewActivity.class));

                Dog dog = new Dog();
                int dogAge = dog.age;
                dog.increaseAge();
            }
        });

        findViewById(R.id.dataBindingTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,DataBingdingActivity.class));
            }
        });

        findViewById(R.id.clearEditViewTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClearEditViewTestActivity.class));
            }
        });

        findViewById(R.id.splashTextTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SplashActivity.class));
            }
        });

        findViewById(R.id.welcomeTextTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WecomeActivity.class));
            }
        });

        findViewById(R.id.gifShowTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowGifActivity.class));
            }
        });
    }
}

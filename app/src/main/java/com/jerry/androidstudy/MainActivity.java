package com.jerry.androidstudy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jerry.androidstudy.database.JerryDataBase;
import com.jerry.androidstudy.database.User;
import com.jerry.androidstudy.databinding.DataBingdingActivity;
import com.jerry.androidstudy.javareview.Dog;
import com.jerry.androidstudy.okhttp.ThreadPoolManager;
import com.jerry.androidstudy.retrofit.GitHubService;
import com.jerry.androidstudy.retrofit.Repo;
import com.jerry.androidstudy.service.HandlerThreadActivity;
import com.jerry.androidstudy.service.MyService;
import com.jerry.androidstudy.ui.ClearEditViewTestActivity;
import com.jerry.androidstudy.ui.ShowGifActivity;
import com.jerry.androidstudy.ui.SplashActivity;
import com.jerry.androidstudy.ui.WecomeActivity;
import com.jerry.androidstudy.widget.CustomViewActivity;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "jerryMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

//        testDB();
        getData();
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

    private void testDB(){
        final Random random = new Random();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                int i = random.nextInt(100);
                user.uid = i;
                user.firstName = "jerry";
                user.lastName = "xu";
                JerryDataBase.getInstance(MainActivity.this).userDao().insertAll(user);
                List<User> users = JerryDataBase.getInstance(MainActivity.this).userDao().getAll();
                if(null != users && !users.isEmpty()){
                    for(User getUser:users){
                        if(null != getUser){
                            Log.i(TAG,"getUser:"+getUser.toString());
                        }
                    }
                }else {
                    Log.i(TAG,"users null");
                }
            }
        });
        thread.start();
    }

    private void getData(){
        Log.i(TAG,"getData");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos("octocat");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()){
                    List<Repo> repos = response.body();
                    Log.i(TAG,"onResponse");
                    Log.i(TAG,"repos list:"+(null != repos?repos.size():-1));
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.i(TAG,"onFailure");
            }
        });
    }
}

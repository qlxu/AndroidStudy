package com.jerry.androidstudy.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jerry.androidstudy.R;

public class DataBingdingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.jerry.androidstudy.databinding.ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        UserBean userBean = new UserBean(20,"jerry");
        binding.setUser(userBean);
        binding.setStr("Tom");
        binding.unbind();
    }
}

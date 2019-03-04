package com.jerry.androidstudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.jerry.androidstudy.aidl.IMyAidlInterface;

public class MyService extends Service {

    private String TAG = this.getClass().getSimpleName();

//    public class MyBind extends Binder{
//        public MyService getService(){
//            Log.i(TAG,"MyBind");
//            return MyService.this;
//        }
//    }

    public class MyBind extends IMyAidlInterface.Stub{

        @Override
        public String getName() throws RemoteException {
            return "test";
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return new MyBind();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }


}

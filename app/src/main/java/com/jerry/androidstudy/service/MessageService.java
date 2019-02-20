package com.jerry.androidstudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MessageService extends Service {

    private static final int MSG_SAY_HELLO = 1;


    class ServiceHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == MSG_SAY_HELLO){
                Toast.makeText(MessageService.this,"hello",Toast.LENGTH_SHORT).show();
            }else {
                super.handleMessage(msg);
            }

        }
    }
    Messenger messenger = new Messenger(new ServiceHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


}

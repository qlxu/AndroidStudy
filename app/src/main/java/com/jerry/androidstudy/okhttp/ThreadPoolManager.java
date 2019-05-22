package com.jerry.androidstudy.okhttp;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
    private static ThreadPoolManager mInstance = new ThreadPoolManager();

    public static ThreadPoolManager getInstance(){
        return mInstance;
    }

//    private ThreadPoolManager(){
//        mThreadPoolExecutor = new ThreadPoolExecutor(3,10, TimeUnit.SECONDS,new ArrayStoreException())
//
//
//    };
    private LinkedBlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

    public void addTask(Runnable runnable){
        if(null != runnable){
            try {
                mQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private ThreadPoolExecutor mThreadPoolExecutor;

    public Runnable coreThread = new Runnable() {
        @Override
        public void run() {
            try {
                mQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            mThreadPoolExecutor.execute(run(););
        }
    };
}

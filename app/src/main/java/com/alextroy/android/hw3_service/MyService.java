package com.alextroy.android.hw3_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {

    private final static int MODE = Service.START_NOT_STICKY;
    private MyBinder binder = new MyBinder();
    private final Random mGenerator = new Random();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getRandomNumber();
                stopSelf();
            }
        }).start();

        return MODE;
    }

    class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}

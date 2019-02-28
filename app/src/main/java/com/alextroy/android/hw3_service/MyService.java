package com.alextroy.android.hw3_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private final static int MODE = Service.START_NOT_STICKY;
    private LocalBinder binder = new LocalBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return MODE;
    }

    public class LocalBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void toast() {
        Toast.makeText(this, "Toast from Service", Toast.LENGTH_SHORT).show();
    }
}

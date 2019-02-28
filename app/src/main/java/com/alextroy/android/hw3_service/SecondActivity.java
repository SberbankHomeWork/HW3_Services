package com.alextroy.android.hw3_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unBindService();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }

    public void bindService() {
        bindService(MyService.newIntent(SecondActivity.this), serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void unBindService() {
        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService boundService = ((MyService.LocalBinder) service).getService();
            Log.v("SecondAct", "connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v("SecondAct", "disconnected");
        }
    };
}

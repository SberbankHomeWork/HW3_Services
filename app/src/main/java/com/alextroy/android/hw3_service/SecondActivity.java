package com.alextroy.android.hw3_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements ServiceConnection {

    private MyService service;
    private boolean isConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (isConnected) {
            service.toast();
        }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        isConnected = true;
        this.service = ((MyService.LocalBinder) service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        isConnected = false;
        this.service = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop() {
        super.onStop();
        unbindService(this);
        this.service = null;
        isConnected = false;
    }
}

package com.alextroy.android.hw3_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startService;
    private Button startSecondAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListeners();
    }

    private void init() {
        startService = findViewById(R.id.start_service);
        startSecondAct = findViewById(R.id.start_second_act);
    }

    private void initListeners() {
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MyService.class);
                startService(intent);
            }
        });

        startSecondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SecondActivity.newIntent(MainActivity.this));
            }
        });
    }
}

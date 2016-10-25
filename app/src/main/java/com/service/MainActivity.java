package com.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.service.broadcastreceiver.BroadcastReceiverActivity;
import com.service.resultreceiver.ResultReceiverActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickResultReceiver(View view){
        Intent intent = new Intent(this,ResultReceiverActivity.class);
        startActivity(intent);
    }

    public void onClickBroadcastReceiver(View view){
        Intent intent = new Intent(this,BroadcastReceiverActivity.class);
        startActivity(intent);
    }
}

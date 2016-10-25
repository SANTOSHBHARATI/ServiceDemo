package com.service.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.service.R;
import com.service.consts.Constants;
import com.service.resultreceiver.MyIntentService;

/**
 * Created by santosh.bharati on 10/25/2016.
 */

public class BroadcastReceiverActivity extends AppCompatActivity {
    private EditText etInput;
    private TextView etOutput;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_broadcast);
        etInput = (EditText) findViewById(R.id.et_receiver);
        etOutput = (TextView) findViewById(R.id.tv_result);
    }


    public void onBroadcastReceiverClick(View view) {
        Intent i = new Intent(this, IntentServiceBroadcastReceiver.class);
        i.putExtra(Constants.RECEIVER_KEY, etInput.getText().toString());
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Constants.ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int resultCode = intent.getIntExtra(Constants.RESULT_CODE, RESULT_CANCELED);
            if (resultCode == RESULT_OK) {
                String resultValue = intent.getStringExtra(Constants.RECEIVER_RESULT);
                Toast.makeText(BroadcastReceiverActivity.this, resultValue, Toast.LENGTH_SHORT).show();
            }
        }
    };
}

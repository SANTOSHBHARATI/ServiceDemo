package com.service.resultreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.service.R;
import com.service.consts.Constants;

/**
 * Created by santosh.bharati on 10/25/2016.
 */

public class ResultReceiverActivity extends AppCompatActivity {

    private MyResultReceiver myResultReceiver;
    private EditText etInput;
    private TextView etOutput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultreceiver);
        etInput = (EditText) findViewById(R.id.et_receiver);
        etOutput = (TextView) findViewById(R.id.tv_result);
        setupServiceReceiver();
    }

    public void onResultReceiverClick(View view) {
        Intent i = new Intent(this, MyIntentService.class);
        i.putExtra(Constants.RECEIVER_KEY, etInput.getText().toString());
        i.putExtra(Constants.RECEIVER, myResultReceiver);
        startService(i);
    }

    // Setup the callback for when data is received from the service
    public void setupServiceReceiver() {
        myResultReceiver = new MyResultReceiver(new Handler());
        // This is where we specify what happens when data is received from the service
        myResultReceiver.setReceiver(new MyResultReceiver.Receiver() {
            @Override
            public void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == RESULT_OK) {
                    String resultValue = resultData.getString(Constants.RECEIVER_RESULT);
                    etOutput.setText(resultValue);
                    Toast.makeText(ResultReceiverActivity.this, resultValue, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

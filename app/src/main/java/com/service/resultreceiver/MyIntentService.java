package com.service.resultreceiver;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.provider.SyncStateContract;

import com.service.consts.Constants;

/**
 * Created by santosh.bharati on 10/25/2016.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        // Used to name the worker thread, important only for debugging.
        super("MyIntentServiceThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Extract the receiver passed into the service
        ResultReceiver resultReceiver = intent.getParcelableExtra(Constants.RECEIVER);
        // Extract additional values from the bundle
        String val = intent.getStringExtra(Constants.RECEIVER_KEY);
        // To send a message to the Activity, create a pass a Bundle
        Bundle bundle = new Bundle();
        bundle.putString(Constants.RECEIVER_RESULT, val);
        // Here we call send passing a resultCode and the bundle of extras
        resultReceiver.send(Activity.RESULT_OK, bundle);
    }
}

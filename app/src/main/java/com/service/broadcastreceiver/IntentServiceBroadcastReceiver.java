package com.service.broadcastreceiver;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.service.consts.ConstData;

/**
 * Created by santosh.bharati on 10/25/2016.
 */

public class IntentServiceBroadcastReceiver extends IntentService {
    public IntentServiceBroadcastReceiver() {
        super("IntentServiceBroadcastReceiver");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String val = intent.getStringExtra(ConstData.RECEIVER_KEY);
        Intent in = new Intent(ConstData.ACTION);
        in.putExtra(ConstData.RESULT_CODE, Activity.RESULT_OK);
        in.putExtra(ConstData.RECEIVER_RESULT, val);
        // Fire the broadcast with intent packaged
        LocalBroadcastManager.getInstance(this).sendBroadcast(in);
    }
}

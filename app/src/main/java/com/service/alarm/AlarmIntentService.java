package com.service.alarm;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by santosh.bharati on 10/26/2016.
 */

public class AlarmIntentService extends IntentService {
    public AlarmIntentService() {
        super("AlarmIntentServiceThread");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("AlarmIntentService", "Service running");
    }
}

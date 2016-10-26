package com.service.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.service.consts.ConstData;

/**
 * Created by santosh.bharati on 10/26/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,AlarmIntentService.class);
        intent1.putExtra(ConstData.ALARM_KEY,"Reminder");
        context.startService(intent1);
    }
}

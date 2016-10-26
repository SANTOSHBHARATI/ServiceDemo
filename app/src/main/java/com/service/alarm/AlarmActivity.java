package com.service.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.service.R;
import com.service.broadcastreceiver.IntentServiceBroadcastReceiver;
import com.service.consts.ConstData;

/**
 * Created by santosh.bharati on 10/26/2016.
 */

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }


    public void onAlarmStartClick(View view) {
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,ConstData.REQUEST_CODE,i,PendingIntent.FLAG_UPDATE_CURRENT);
        long duration = System.currentTimeMillis();
        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,duration,AlarmManager.INTERVAL_HALF_HOUR,pendingIntent);
    }

    public void onAlarmStopClick(View view) {
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,ConstData.REQUEST_CODE,i,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}

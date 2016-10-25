package com.service.resultreceiver;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by santosh.bharati on 10/25/2016.
 */

// Defines a generic receiver used to pass data to Activity from a Service
public class MyResultReceiver extends ResultReceiver {

    private Receiver receiver;

    public MyResultReceiver(Handler handler) {
        super(handler);
    }

    // Setter for assigning the receiver
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // Pass the result to the receiver if the receiver has been assigned
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if(receiver!=null){
            receiver.onReceiveResult(resultCode,resultData);
        }
    }

    // Defines interface for communication
    interface Receiver{
       void onReceiveResult(int resultCode, Bundle resultData);
    }
}

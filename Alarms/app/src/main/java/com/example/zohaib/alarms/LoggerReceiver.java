package com.example.zohaib.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zohaib on 12/7/15.
 */
public class LoggerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context , "Logger Receiver" , Toast.LENGTH_SHORT).show();
    }
}

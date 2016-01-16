package com.example.zohaib.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private AlarmManager mAMgr;
    private AlarmManager mALMgr;
    private Intent mARcvIntent , mLRcvIntent;
    private PendingIntent mARcvPInt, mLRcvPInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button setOnce = (Button) findViewById(R.id.scheduleAlarm);
        Button setRepeating = (Button) findViewById(R.id.button);
        Button setInexactRepeating = (Button) findViewById(R.id.button2);

        mAMgr = (AlarmManager) getSystemService(ALARM_SERVICE);
        mALMgr = (AlarmManager) getSystemService(ALARM_SERVICE);

        mARcvIntent = new Intent(MainActivity.this , AlarmReceiver.class);
        //mLRcvIntent = new Intent(MainActivity.this , LoggerReceiver.class);

        mARcvPInt = PendingIntent.getBroadcast(MainActivity.this, 0 , mARcvIntent ,0);
        //mLRcvPInt = PendingIntent.getBroadcast(MainActivity.this, 0 , mLRcvIntent , 0);

        setOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAMgr.set(AlarmManager.RTC_WAKEUP , System.currentTimeMillis() + 500 , mARcvPInt);
                //mALMgr.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000 , mLRcvPInt);
            }
        });

        setRepeating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAMgr.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 500, System.currentTimeMillis() + 1000, mARcvPInt);
            }
        });

        setInexactRepeating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP , System.currentTimeMillis() + 500 , System.currentTimeMillis() +1000 , mARcvPInt);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

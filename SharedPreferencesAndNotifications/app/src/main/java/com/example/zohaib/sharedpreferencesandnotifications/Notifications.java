package com.example.zohaib.sharedpreferencesandnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.*;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Notifications extends AppCompatActivity {

    int notificationID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        //Toast Notification:
        Toast.makeText(getApplicationContext() , "Toast Notif" , Toast.LENGTH_SHORT).show();

        //Toast Notification with Custom View
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER , 0 , 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(getLayoutInflater().inflate(R.layout.toastnotification, null));
        toast.show();

        //Press Toast to go to new Activity
        NotificationCompat.Builder mbuild = new NotificationCompat.Builder(this);
        mbuild.setSmallIcon(R.drawable.notification_template_icon_bg);
        mbuild.setContentTitle("Status Bar Notif");
        mbuild.setContentText("Hi there ");

        Intent gotoActivity = new Intent(Notifications.this , ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(gotoActivity);

        PendingIntent gotoPending = stackBuilder.getPendingIntent(0 , PendingIntent.FLAG_UPDATE_CURRENT);
        mbuild.setContentIntent(gotoPending);

        NotificationManager mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mManager.notify(notificationID , mbuild.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notifications, menu);
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

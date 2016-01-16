package com.example.zohaib.sharedpreferencesandnotifications;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        final android.content.SharedPreferences sp = getSharedPreferences("myPref" , Context.MODE_PRIVATE);

        android.content.SharedPreferences.Editor se = sp.edit();

        se.putString("Key1", "Value1");

        se.commit();

        Button dispBtn = (Button) findViewById(R.id.getbtn);
        final TextView dispText = (TextView) findViewById(R.id.showtext);

        dispBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispText.setText(sp.getString("Key1", null).toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shared_preferences, menu);
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

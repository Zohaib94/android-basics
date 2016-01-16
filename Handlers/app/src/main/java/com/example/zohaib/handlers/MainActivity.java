package com.example.zohaib.handlers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
//05
import android.os.Handler;
//06
import android.view.View;
//07
import android.widget.ProgressBar;
public class MainActivity extends Activity {
    private Handler handler;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);}
    public void startProgress(View view) {
        new Thread(new Task()).start();}
    class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                final int value = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });
            }

        }

    }

}

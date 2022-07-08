package com.iot.a20220707_handlerprogress;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final long DELAY_MS = 100;
    public static final int WHAT_PROGRESS = 1;
    private ProgressBar progressBar;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (progressBar.getProgress()>0){
                progressBar.setProgress(progressBar.getProgress()-1);
            }
            handler.sendEmptyMessageDelayed(WHAT_PROGRESS, DELAY_MS);
            if (progressBar.getProgress()==0){
                handler.removeMessages(1);
                Intent intent = new Intent(MainActivity.this, Boom.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        handler.sendEmptyMessageDelayed(WHAT_PROGRESS, DELAY_MS);

        View view = findViewById(R.id.main_layout);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeMessages(1);
                ((TextView)findViewById(R.id.textView)).setText("Stop Boob!!");
            }
        });
    }
}
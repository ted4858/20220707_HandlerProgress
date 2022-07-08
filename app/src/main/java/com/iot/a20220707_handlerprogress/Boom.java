package com.iot.a20220707_handlerprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Boom extends AppCompatActivity {
    private  int count = 5;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ((TextView)findViewById(R.id.textView)).setText(count+"");
            count -= 1;

            if (count == 0) {
                Intent intent = new Intent(Boom.this, MainActivity.class);
                startActivity(intent);
            }else {
                handler.postDelayed(runnable, 1000);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom);

        handler.post(runnable);
    }
}
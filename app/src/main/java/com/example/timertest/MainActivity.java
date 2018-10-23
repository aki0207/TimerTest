package com.example.timertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends Activity {
    final Handler handler = new Handler();
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textView);



        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            int count = 0;
            String counter = "";
            @Override
            public void run() {
                // UIスレッド
                count++;
                if (count > 5) { // 5回実行したら終了
                    return;
                }

                counter = String.valueOf(count);
                textView.setText(counter); // 何かやる
                handler.postDelayed(this, 5000);
            }
        };
        handler.post(r);

    }


}
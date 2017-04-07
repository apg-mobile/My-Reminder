package com.example.example.myreminder;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vijaya.Karri on 6/4/2017.
 */

public class CountDownTimerActivity extends AppCompatActivity {

    private TextView textViewTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdowntimer);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);


        //start button click
        CountDown timer = new CountDown(20000, 1000);
        timer.start();

    }
        //countdown class
        private class CountDown extends CountDownTimer {

            CountDown(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                String text = String.format("%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                textViewTimer.setText(text);
            }

            @Override
            public void onFinish() {
                textViewTimer.setText("finish");
            }
        }

}

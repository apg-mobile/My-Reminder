package com.example.example.myreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int jobId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startReminder = (Button)findViewById(R.id.reminderButtonStart);

        startReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CountDownTimerActivity.class);
                startActivity(intent);
                jobId = MyReminderJob.scheduleJob();
                Toast.makeText(MainActivity.this,"Starting Alarm: "+jobId,Toast.LENGTH_LONG).show();
            }
        });
    }
}

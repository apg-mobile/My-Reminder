package com.example.example.myreminder;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vijaya.Karri on 5/4/2017.
 */

public class MyReminderJob extends Job {

    public static final String TAG = "job_demo_tag";

    @NonNull
    @Override
    protected Result onRunJob(Params params) {

        PendingIntent pi = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(),ResultActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            pi.send();
        }catch(PendingIntent.CanceledException e){
            e.printStackTrace();
        }
        return Result.SUCCESS;
    }

    static int scheduleJob(){
        return new JobRequest.Builder(MyReminderJob.TAG)
                .setExact(20*1000)
                .setUpdateCurrent(true)
                .setPersisted(false)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .build()
                .schedule();
    }

    static void cancelJob(int jobId) {
        JobManager.instance().cancel(jobId);
    }
}

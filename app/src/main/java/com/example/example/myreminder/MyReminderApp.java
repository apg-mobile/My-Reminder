package com.example.example.myreminder;

import android.app.Application;

import com.evernote.android.job.JobManager;

/**
 * Created by Vijaya.Karri on 5/4/2017.
 */

public class MyReminderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JobManager.create(this).addJobCreator(new DemoJobCreator());
    }
}

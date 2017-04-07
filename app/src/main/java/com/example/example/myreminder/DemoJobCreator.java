package com.example.example.myreminder;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by Vijaya.Karri on 5/4/2017.
 */

public class DemoJobCreator implements JobCreator {

    @Override
    public Job create(String tag) {
        switch (tag){
            case MyReminderJob.TAG:
                return new MyReminderJob();
            default:
                return null;
        }
    }
}

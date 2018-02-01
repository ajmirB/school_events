package com.xception.schoolevents;

import android.app.Application;

import com.xception.schoolevents.helper.ApplicationHelper;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // To have an access of the application context in every class
        ApplicationHelper.initInstance(this);
    }
}

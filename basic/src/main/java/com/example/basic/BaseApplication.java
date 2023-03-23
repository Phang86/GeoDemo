package com.example.basic;

import android.app.Application;
import android.os.Build;

public class BaseApplication extends Application {

    private static boolean isApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        isApplication = BuildConfig.isApplication;
    }
}

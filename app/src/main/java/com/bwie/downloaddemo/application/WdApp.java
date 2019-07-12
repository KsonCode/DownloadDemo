package com.bwie.downloaddemo.application;

import android.app.Application;
import android.content.Context;


public class WdApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //fresco初始化

    }
}

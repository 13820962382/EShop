package com.example.administrator.eshop.activity.bugly;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Administrator on 2017/2/28.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "0e9d9ed5db", true);
    }
}

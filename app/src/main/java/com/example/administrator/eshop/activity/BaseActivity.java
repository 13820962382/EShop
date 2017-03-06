package com.example.administrator.eshop.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.administrator.eshop.R;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Administrator on 2017/3/3.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private int push_right_in;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "5AdZsa4DUMGx0vn3LUyVj78L");
        CrashReport.initCrashReport(getApplicationContext(), "0e9d9ed5db", true);
        initView();
        initData();

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

    protected abstract int getContentViewId();

    public abstract void initView();

    public abstract void initData();

}

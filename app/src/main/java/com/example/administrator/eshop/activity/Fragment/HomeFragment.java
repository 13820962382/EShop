package com.example.administrator.eshop.activity.fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.api.OkHttpUtil;
import com.example.administrator.eshop.activity.base.BaseFragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/25.
 */

public class HomeFragment extends BaseFragment {

    private static final String HOME_URL = "http://106.14.32.204/eshop/emobile/?url=/home/data";
    public Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

        Call call = OkHttpUtil.getInstance().getCall(HOME_URL);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}

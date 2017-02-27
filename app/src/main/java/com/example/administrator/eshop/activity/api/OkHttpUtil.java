package com.example.administrator.eshop.activity.api;

import com.example.administrator.eshop.activity.mode.Category;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/24.
 */

public class OkHttpUtil {
    private OkHttpClient httpClient;

    public static synchronized OkHttpUtil getInstance() {
        OkHttpUtil httpUtil = new OkHttpUtil();
        return httpUtil;
    }

    private OkHttpUtil() {
        httpClient = new OkHttpClient();
    }

    public Call getCall(String url) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = httpClient.newCall(request);

        return call;
    }

}

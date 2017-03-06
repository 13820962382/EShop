package com.example.administrator.eshop.activity.api;

import com.example.administrator.eshop.activity.mode.Filter;
import com.example.administrator.eshop.activity.mode.SearchReq;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

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

    public Call postCall(String url, SearchReq param) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(param);
        RequestBody body = new FormBody.Builder()
                .add("json", jsonString)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = httpClient.newCall(request);

        return call;
    }

}

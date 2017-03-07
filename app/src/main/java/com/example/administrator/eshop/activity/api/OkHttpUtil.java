package com.example.administrator.eshop.activity.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.administrator.eshop.activity.adapter.SearchAdapter;
import com.example.administrator.eshop.activity.mode.Filter;
import com.example.administrator.eshop.activity.mode.ResponseEntity;
import com.example.administrator.eshop.activity.mode.SearchReq;
import com.example.administrator.eshop.activity.mode.SearchRsp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/24.
 */

public class OkHttpUtil {
    private OkHttpClient httpClient;
    private List simpleGoodsList1 = new ArrayList();
    private Handler handler = new Handler(Looper.getMainLooper());
    private SearchRsp searchRsp;

    public static synchronized OkHttpUtil getInstance() {
        OkHttpUtil httpUtil = new OkHttpUtil();
        return httpUtil;
    }

    private OkHttpUtil() {
        httpClient = new OkHttpClient();
//        this.context = context;
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

    public void OnRefresh(String url, final SearchReq param, final SearchAdapter adapter){
        final Gson gson = new Gson();
        String jsonString = gson.toJson(param);
        RequestBody body = new FormBody.Builder()
                .add("json", jsonString)
                .build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Toast.makeText(, "访问失败", Toast.LENGTH_SHORT).show()
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        try {
                            searchRsp = gson.fromJson(response.body().string(), SearchRsp.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        simpleGoodsList1 = searchRsp.getData();
                        adapter.upData(simpleGoodsList1);
                    }
                });

            }
        });

    }

}

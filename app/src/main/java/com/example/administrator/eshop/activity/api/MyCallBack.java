package com.example.administrator.eshop.activity.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.administrator.eshop.activity.mode.ResponseEntity;
import com.example.administrator.eshop.activity.mode.SearchRsp;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/27.
 */

public abstract class MyCallBack implements Callback {

    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());
    private SearchRsp searchRsp;

    public MyCallBack(Context context) {
        this.context = context;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "访问失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResponse(final Call call, final Response response)  {
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    MyOnResponse(call,response);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    protected abstract void MyOnResponse(Call call, Response response)throws IOException;

}

package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    @butterknife.BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);

    }

    @butterknife.OnClick(R.id.btn)
    public void onClick() {
        final OkHttpClient httpClient = new OkHttpClient();
        Request request =  new Request.Builder()
                .get()
                .url("http://106.14.32.204/eshop/emobile/?url=/category")
                .build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("tag","onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("tag",""+response.code());
            }
        });

    }
}

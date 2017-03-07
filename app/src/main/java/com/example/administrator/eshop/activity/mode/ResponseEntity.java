package com.example.administrator.eshop.activity.mode;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gqq on 2017/3/1.
 */

// 响应的实体基类：为了防止直接实例化，所以做成抽象类
public abstract class ResponseEntity {

    @SerializedName("status")
    private Status mStatus;

    public Status getStatus() {
        return mStatus;
    }
}

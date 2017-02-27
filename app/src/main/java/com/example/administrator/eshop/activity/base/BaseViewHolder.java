package com.example.administrator.eshop.activity.base;

import android.view.View;

/**
 * Created by Administrator on 2017/2/24.
 */

public abstract class BaseViewHolder<T> {
   public View itemView;
    public BaseViewHolder(View itemView){
        this.itemView =itemView;
    }

    public abstract void initWidget(T data);
}

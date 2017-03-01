package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LRecyclerViewAdapter extends LRecyclerView.Adapter {
    private List list;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

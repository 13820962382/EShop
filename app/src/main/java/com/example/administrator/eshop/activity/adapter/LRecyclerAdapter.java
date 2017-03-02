package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.SimpleGoods;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LRecyclerAdapter extends CommonAdapter<SimpleGoods> {
    private List<SimpleGoods> list;

    public LRecyclerAdapter(Context context, List list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
    }


    @Override
    public void setData(BaseViewHolder holder, SimpleGoods data, int viewType) {
        switch (viewType){
            case 0:
                holder.setImageView(R.id.tv_home_item_title,data.getName());
                holder.setImageView(R.id.img_home_item01,data.getImg().getLarge());
                holder.setImageView(R.id.img_home_item02,data.getImg().getLarge());
                holder.setImageView(R.id.img_home_item03,data.getImg().getLarge());
//                holder.setImageView(R.id.img_home_item04,data.getImg().getLarge());
//                holder.setImageView(R.id.img_home_item05,data.getImg().getLarge());
                break;
        }


    }

}

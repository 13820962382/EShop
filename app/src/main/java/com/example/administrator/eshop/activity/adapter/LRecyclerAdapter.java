package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.SimpleGoods;
import com.example.administrator.eshop.activity.mode.mymode.Category;
import com.example.administrator.eshop.activity.mode.mymode.HomeCategory;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LRecyclerAdapter extends CommonAdapter<HomeCategory.DataBean>implements BaseViewHolder.OnItemClickListener{
    private List<HomeCategory.DataBean> list;
    private int[] itemLayoutId;
    private Context context;

    public LRecyclerAdapter(Context context, List list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
        this.context = context;
        this.list=list;
        this.itemLayoutId=itemLayoutId;
    }


//    @Override
//    public void setOnItemClickListener(OnItemClickListener listener) {
//
//    }

    @Override
    public void setData(BaseViewHolder holder, HomeCategory.DataBean data, int viewType) {
        holder.setTextView(R.id.tv_home_item_title, data.getName());
        initHolder(holder,data,viewType);
        setViewOnClick(holder, viewType);
    }

    private void setViewOnClick(BaseViewHolder holder, int viewType) {
        holder.setViewOnClick(R.id.img_home_item03,itemLayoutId,viewType,new BaseViewHolder.OnItemClickListener() {
            @Override
            public void OnItemClick(View view) {
                Toast.makeText(context, "王哈哈", Toast.LENGTH_SHORT).show();
            }
        });
        holder.setViewOnClick(R.id.img_home_item05,itemLayoutId,viewType,this);
    }


    public void initHolder(BaseViewHolder holder, HomeCategory.DataBean data, int viewType) {
        switch (viewType) {
            case 0:
                holder.setImageView(R.id.img_home_item01, data.getGoods().get(0).getImg().getUrl());
                holder.setImageView(R.id.img_home_item02, data.getGoods().get(1).getImg().getUrl());
                holder.setImageView(R.id.img_home_item03, data.getGoods().get(2).getImg().getUrl());
                break;
            case 1:
                holder.setImageView(R.id.img_home_item01, data.getGoods().get(0).getImg().getUrl());
                holder.setImageView(R.id.img_home_item02, data.getGoods().get(1).getImg().getUrl());
                holder.setImageView(R.id.img_home_item03, data.getGoods().get(2).getImg().getUrl());
                holder.setImageView(R.id.img_home_item04, data.getGoods().get(3).getImg().getUrl());
                holder.setImageView(R.id.img_home_item05, data.getGoods().get(4).getImg().getUrl());
                break;
            case 2:
                holder.setImageView(R.id.img_home_item01, data.getGoods().get(0).getImg().getUrl());
                holder.setImageView(R.id.img_home_item02, data.getGoods().get(1).getImg().getUrl());
                holder.setImageView(R.id.img_home_item03, data.getGoods().get(2).getImg().getUrl());
                holder.setImageView(R.id.img_home_item04, data.getGoods().get(3).getImg().getUrl());
                break;
        }

//        List urlList = new ArrayList();
//        for (int i = 0; i < data.getGoods().size(); i++) {
//            urlList.add(data.getGoods().get(i).getImg().getUrl());
//        }
//        int[] viewIds = new int[]{R.id.img_home_item01,R.id.img_home_item02,R.id.img_home_item03,R.id.img_home_item04,R.id.img_home_item05};
//        holder.setImageView(viewIds,itemLayoutId,viewType,urlList);
    }

    @Override
    public void OnItemClick(View view) {
        Toast.makeText(context, "这是第五张图片", Toast.LENGTH_SHORT).show();
    }
}

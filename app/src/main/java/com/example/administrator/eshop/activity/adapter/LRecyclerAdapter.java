package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.GoodsActivity;
import com.example.administrator.eshop.activity.MainActivity;
import com.example.administrator.eshop.activity.SearchActivity;
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

    @Override
    public void setData(BaseViewHolder holder, HomeCategory.DataBean data, int viewType) {
        holder.setTextView(R.id.tv_home_item_title, data.getName());
        initHolder(holder,data,viewType);
        setViewOnClick(holder, viewType);
    }

    private void setViewOnClick(BaseViewHolder holder, int viewType) {
        holder.setViewOnClick(R.id.img_home_item01,itemLayoutId,viewType,this);
        holder.setViewOnClick(R.id.img_home_item02,itemLayoutId,viewType,this);
        holder.setViewOnClick(R.id.img_home_item03,itemLayoutId,viewType,this);
        holder.setViewOnClick(R.id.img_home_item04,itemLayoutId,viewType,this);
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
    }
    // TODO: 2017/3/5 商品详情待实现
    @Override
    public void OnItemClick(View view) {
        switch (view.getId()){
            case R.id.img_home_item01:
                Intent intent = new Intent(context,GoodsActivity.class);
                context.startActivity(intent);
                break;
            case R.id.img_home_item02:
                Toast.makeText(context, "商品2详情待实现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_home_item03:
                Toast.makeText(context, "商品3详情待实现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_home_item04:
                Toast.makeText(context, "商品4详情待实现", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_home_item05:
                Toast.makeText(context, "商品5详情待实现", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

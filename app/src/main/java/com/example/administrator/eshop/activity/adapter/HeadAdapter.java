package com.example.administrator.eshop.activity.adapter;

import android.content.Context;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.mode.mymode.HomeBanner;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class HeadAdapter  extends CommonAdapter<HomeBanner.DataBean.PromoteGoodsBean>{

    public HeadAdapter(Context context, List list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void setData(BaseViewHolder holder, HomeBanner.DataBean.PromoteGoodsBean data, int viewType) {
        holder.setPicassoImage(R.id.promotpe_goods,data.getImg().getThumb());

    }

}

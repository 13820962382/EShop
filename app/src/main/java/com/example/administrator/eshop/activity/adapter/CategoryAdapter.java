package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */

public class CategoryAdapter extends ListBaseAdapter<Category.DataBean> {

    public CategoryAdapter(Context context, List<Category.DataBean> list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_primary_category;
    }

    @Override
    protected void setHolder(BaseViewHolder holder, Category.DataBean data) {
        holder.setTextView(R.id.text_category,data.getName());
    }

//    public CategoryAdapter(Context context, List<Category.DataBean> list, int[] itemLayoutId) {
//        super(context, list, itemLayoutId);
//    }
//
//
//    @Override
//    public void setData(BaseViewHolder holder, Category.DataBean data, int viewType) {
//        holder.setTextView(R.id.text_category,data.getName());
//    }


//    public class CaViewHolder extends BaseViewHolder{
//        View itemView;
//        TextView textView;
//
//        public CaViewHolder(View itemView, Context context) {
//            super(itemView, context);
//        }
//    }
}

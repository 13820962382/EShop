package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */

public class ChildrenAdapter extends ListBaseAdapter<Category.DataBean.ChildrenBean> {
    private List<Category.DataBean.ChildrenBean> list;

    public ChildrenAdapter(Context context, List<Category.DataBean.ChildrenBean> list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_children_category;
    }

    @Override
    protected void setHolder(BaseViewHolder holder, Category.DataBean.ChildrenBean data) {
        holder.setTextView(R.id.text_category,data.getName());
    }

//    public ChildrenAdapter(Context context, List<Category.DataBean.ChildrenBean> list, int[] itemLayoutId) {
//        super(context, list, itemLayoutId);
//    }
//
//    @Override
//    public void setData(BaseViewHolder holder, Category.DataBean.ChildrenBean data, int viewType) {
//        holder.setTextView(R.id.text_category,data.getName());
//    }
}

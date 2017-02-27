package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */

public class ChildrenAdapter extends ListBaseAdapter<Category.DataBean.ChildrenBean> {
    private List<Category.DataBean.ChildrenBean> list;

    public ChildrenAdapter(Context context, List list) {
        super(context, list);
        this.list = list;
    }

    @Override
    protected BaseViewHolder getViewHolder(View itemView, int position) {
        ChiHolder holder = new ChiHolder(itemView);
        holder.initWidget(list.get(position));

        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_children_category;
    }

    public static class ChiHolder extends BaseViewHolder<Category.DataBean.ChildrenBean> {
        View itemView;
        TextView textView;

        public ChiHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.text_category);
        }


        @Override
        public void initWidget(Category.DataBean.ChildrenBean data) {
            textView.setText(data.getName());

        }
    }
}

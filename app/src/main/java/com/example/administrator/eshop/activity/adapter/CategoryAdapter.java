package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.ListBaseAdapter;
import com.example.administrator.eshop.activity.mode.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */

public class CategoryAdapter extends ListBaseAdapter<Category.DataBean>{
    private List<Category.DataBean> list;


    public CategoryAdapter(Context context, List list) {
        super(context, list);
        this.list=list;
    }

    @Override
    protected BaseViewHolder getViewHolder(View itemView, int position) {
        CaViewHolder holder = new CaViewHolder(itemView);
        holder.initWidget(list.get(position));

        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_primary_category;
    }


    public class CaViewHolder extends BaseViewHolder<Category.DataBean>{
        View itemView;
        TextView textView;

        public CaViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.text_category);

        }

        @Override
        public void initWidget(Category.DataBean data) {
            textView.setText(data.getName());

        }


    }
}

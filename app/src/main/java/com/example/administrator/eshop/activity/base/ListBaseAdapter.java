package com.example.administrator.eshop.activity.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */

public abstract class ListBaseAdapter<T> extends BaseAdapter {
    private List<T> list;
    private Context context;
    int[] itemLayoutId;

    public ListBaseAdapter(Context context, List<T> list, int[] itemLayoutId) {
        this.list = list;
        this.context = context;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addData(List<T> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void upData(List<T> data) {
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    ;

    public void updateData(List<T> data) {
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();

    }

    ;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(getLayoutId(), viewGroup, false);
            holder = new BaseViewHolder(view, context);
            setHolder(holder, list.get(i));
            view.setTag(holder);
        }

        holder = (BaseViewHolder) view.getTag();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void setHolder(BaseViewHolder holder, T data);


}

package com.example.administrator.eshop.activity.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.mode.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<T> list;
    private int[] itemLayoutId;
    private int itemPosition;
    private  OnItemClickListener listener;

    public CommonAdapter(Context context, List<T> list, int[] itemLayoutId) {
        this.list = list;
        this.context = context;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(itemLayoutId[viewType], parent, false);
        BaseViewHolder holder = new BaseViewHolder(itemView, context);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
         itemPosition = position;
        setData(holder, list.get(position), getItemViewType(position));
        if (listener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(view,position);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public T getItem(int position){

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position % itemLayoutId.length;
    }

    public void upData(List<T> data){
        this.list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }
    public void addData(List<T> data){
        list.addAll(data);
        notifyDataSetChanged();
    }

 public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public abstract void setData(BaseViewHolder holder, T data, int viewType);

    public interface OnItemClickListener {

        void OnItemClick(View view, int position);

    }

}

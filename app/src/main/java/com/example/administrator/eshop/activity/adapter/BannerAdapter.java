package com.example.administrator.eshop.activity.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.eshop.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public abstract class BannerAdapter<T> extends PagerAdapter {
    private List<T> list = new ArrayList();
    private View view;

    public void addData(List data) {
        this.list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        ViewHolder holder = (ViewHolder) object;
        return view == holder.imageView;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_banner,container,false);
        container.addView(view);
        ViewHolder holder = new ViewHolder(view);
        bind(holder,list.get(position));
        return holder;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewHolder viewHolder = (ViewHolder) object;
        container.removeView(viewHolder.itemView);
    }
    public static class ViewHolder{
       public View itemView;
       public ImageView imageView;


        public ViewHolder(View itemView) {
            this.itemView = itemView;
            this.imageView = (ImageView) itemView.findViewById(R.id.image_banner_item);
        }
    }
    protected abstract void bind(ViewHolder holder,T data);
}

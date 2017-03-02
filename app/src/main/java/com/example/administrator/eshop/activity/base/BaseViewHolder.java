package com.example.administrator.eshop.activity.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.eshop.R;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;

/**
 * Created by Administrator on 2017/2/24.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{

    public View itemView;
    private Context context;
    public TextView textView;
    public ImageView imageView;
//    private onItemClickListener listener;

    public BaseViewHolder(View itemView,Context context) {
        super(itemView);
        this.itemView = itemView;
        this.context = context;
//        itemView.setOnClickListener(this);
    }

    public <T extends View> T getViewId(@IdRes int viewId){
        return (T) itemView.findViewById(viewId);
    }

    public void setTextView(@IdRes int viewId,String text){
       textView = getViewId(viewId);
        textView.setText(text);
    }
    public void setImageView(@IdRes int viewId,String url){
   imageView = getViewId(viewId);
        Glide.with(context).load(url).into(imageView);
    }
    public void setPicassoImage(@IdRes int viewId,String url){
       imageView = getViewId(viewId);
        Picasso.with(context).load(url)
                .transform(new CropCircleTransformation())
                .into(imageView);
}

}

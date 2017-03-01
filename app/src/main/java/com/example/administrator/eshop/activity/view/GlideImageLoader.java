package com.example.administrator.eshop.activity.view;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.example.administrator.eshop.activity.mode.Banner;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Created by Administrator on 2017/3/1.
 */
public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
       // Glide.with(context).load(path).into(imageView);
        //Picasso 加载图片简单用法
        Uri uri = Uri.parse((String) path);
        Picasso.with(context).load(uri).into(imageView);

        //用fresco加载图片简单用法，记得要写下面的createImageView方法
       // Uri uri = Uri.parse((String) path);
        //imageView.setImageURI(uri);
    }
}

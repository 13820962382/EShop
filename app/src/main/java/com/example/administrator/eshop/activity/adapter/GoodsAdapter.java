package com.example.administrator.eshop.activity.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class GoodsAdapter extends PagerAdapter {
    private List list;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView();
    }
}

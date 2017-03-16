package com.example.administrator.eshop.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.eshop.activity.fragment.GoodsFragment1;
import com.example.administrator.eshop.activity.fragment.GoodsFragment2;
import com.example.administrator.eshop.activity.fragment.GoodsFragment3;
import com.example.administrator.eshop.activity.fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    private Fragment fragment;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        list.add(new GoodsFragment1());
        list.add(new GoodsFragment2());
        list.add(new GoodsFragment3());
    }

    @Override
    public Fragment getItem(int position) {
       return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

package com.example.administrator.eshop.activity.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.eshop.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/2/24.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    private Toolbar standard_toolbar;
    private TextView standard_toolbar_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initData();
       initToolbar(view);
        return view;
    }

    @LayoutRes
    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unbinder = null;
    }

    public abstract void initView(View view);

    public abstract void initToolbar(View view);

    public abstract void initData();



}

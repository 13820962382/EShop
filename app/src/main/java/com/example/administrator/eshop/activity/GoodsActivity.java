package com.example.administrator.eshop.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.eshop.R;

/**
 * Created by Administrator on 2017/3/7.
 */

public class GoodsActivity extends BaseActivity {
    private TextView text_tab_goods,text_tab_details,text_tab_comments;
    private ViewPager pager_goods;
    private ImageButton button_show_cart;
    private Button button_add_cart,button_buy;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_goods;
    }

    @Override
    public void initView() {
        initTooBar();
        View view = LayoutInflater.from(this).inflate(getContentViewId(),null);
        pager_goods = (ViewPager) view.findViewById(R.id.pager_goods);
        button_show_cart = (ImageButton) view.findViewById(R.id.button_show_cart);
        button_add_cart = (Button) view.findViewById(R.id.button_add_cart);
        button_buy = (Button) view.findViewById(R.id.button_buy);

    }

    private void initTooBar() {
        View view = LayoutInflater.from(this).inflate(R.layout.partial_goods_action_bar,null);
        text_tab_goods = (TextView) view.findViewById(R.id.text_tab_goods);
        text_tab_details = (TextView) view.findViewById(R.id.text_tab_details);
        text_tab_comments = (TextView) view.findViewById(R.id.text_tab_comments);


    }

    @Override
    public void initData() {

    }
}

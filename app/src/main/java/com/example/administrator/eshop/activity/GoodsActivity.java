package com.example.administrator.eshop.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.adapter.FragmentAdapter;
import com.example.administrator.eshop.activity.fragment.GoodsFragment1;
import com.example.administrator.eshop.activity.fragment.GoodsFragment2;
import com.example.administrator.eshop.activity.fragment.GoodsFragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public class GoodsActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
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
//        View view = LayoutInflater.from(this).inflate(getContentViewId(),null);
        pager_goods = (ViewPager) findViewById(R.id.pager_goods);
        button_show_cart = (ImageButton)findViewById(R.id.button_show_cart);
        button_add_cart = (Button)findViewById(R.id.button_add_cart);
        button_buy = (Button)findViewById(R.id.button_buy);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        pager_goods.setAdapter(adapter);
        pager_goods.setOnPageChangeListener(this);
        button_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GoodsActivity.this, "商品", Toast.LENGTH_SHORT).show();
            }
        });

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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

package com.example.administrator.eshop.activity.fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.adapter.HeadAdapter;
import com.example.administrator.eshop.activity.adapter.LRecyclerAdapter;
import com.example.administrator.eshop.activity.api.MyCallBack;
import com.example.administrator.eshop.activity.api.OkHttpUtil;
import com.example.administrator.eshop.activity.base.BaseFragment;
import com.example.administrator.eshop.activity.mode.mymode.HomeBanner;
import com.example.administrator.eshop.activity.mode.SimpleGoods;
import com.example.administrator.eshop.activity.mode.mymode.HomeCategory;
import com.example.administrator.eshop.activity.view.GlideImageLoader;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/25.
 */

public class HomeFragment extends BaseFragment {
    private Toolbar standard_toolbar;
    private TextView standard_toolbar_title;
    private com.youth.banner.Banner banner;
    private static final String HOME_URL = "http://106.14.32.204/eshop/emobile/?url=/home/data";
    private static final String HOME_CATEGORY_URL = "http://106.14.32.204/eshop/emobile/?url=/home/category";
    private List<HomeCategory.DataBean> homeList = new ArrayList();
    private List<HomeBanner.DataBean.PromoteGoodsBean> headList = new ArrayList();
    private List bannerList = new ArrayList();
    private HeadAdapter headAdapter;
    private LRecyclerAdapter lRecyclerAdapter;
    private RecyclerView headRecycler;
    private LRecyclerView lRecyclerView;
    private LRecyclerViewAdapter adapter;
    private View header;
    private OkHttpUtil instance;
    private Call call;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recyclerview;
    }

    @Override
    public void initView(View view) {
//        Fresco.initialize(this);
//        list_home_goods = (ListView) view.findViewById(R.id.list_home_goods);
//        View headView = LayoutInflater.from(getContext()).inflate(R.layout.partial_home_header,list_home_goods,false);
//        bannerLayout = (BannerLayout) headView.findViewById(R.id.layout_banner);
//        bannerAdapter = new BannerAdapter<Banner>() {
//            @Override
//            protected void bind(ViewHolder holder, Banner data) {
////                Picasso.with(getContext()).load(data.getPicture().getLarge()).into(holder.imageView);
//                holder.imageView.setImageResource(R.mipmap.ic_launcher);
//            }
//        };
//        bannerLayout.setBannerAdapter(bannerAdapter);
        //初始化头布局
        header = LayoutInflater.from(getContext()).inflate(R.layout.home_recyclerview_head, (ViewGroup) view, false);
        lRecyclerView = (LRecyclerView) view.findViewById(R.id.lrecyclerview_banner);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        lRecyclerAdapter = new LRecyclerAdapter(getContext(), homeList, new int[]{R.layout.home_recyclerview_item1,R.layout.home_recyclerview_item2,R.layout.home_recyclerview_item3});
        adapter = new LRecyclerViewAdapter(lRecyclerAdapter);

        initBanner(view);
        //添加头布局
        adapter.addHeaderView(header);
        lRecyclerView.setAdapter(adapter);

    }

    private void initBanner(View view) {
        banner = (com.youth.banner.Banner) header.findViewById(R.id.banner);

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
//        //初始化促销单品的适配器
        headAdapter = new HeadAdapter(getContext(), headList, new int[]{R.layout.item_promotpe_goods});
        //初始化Recycler
        headRecycler = (RecyclerView) header.findViewById(R.id.recycler_head);
        headRecycler.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        headRecycler.setAdapter(headAdapter);
    }

    @Override
    public void initToolbar(View view) {

        standard_toolbar = (Toolbar) view.findViewById(R.id.standard_toolbar);
        standard_toolbar_title = (TextView) view.findViewById(R.id.standard_toolbar_title);
        standard_toolbar_title.setText("首页");
        // Fragment显示选项菜单
        setHasOptionsMenu(true);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        // 处理toolbar
        activity.setSupportActionBar(standard_toolbar);
        // 处理actionbar不展示默认的标题
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置返回箭头
        activity.getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
    //下拉刷新
    public void onRefresh(){
            lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh() {
                    getNetData();
                    lRecyclerView.refreshComplete(0);
                    adapter.notifyDataSetChanged();
                }
            });
    }


    @Override
    public void initData() {
        //获取轮播图和促销单品的数据
        getNetData();
        onRefresh();


    }

    private void getNetData() {
        instance = OkHttpUtil.getInstance();
        Call call = instance.getCall(HOME_URL);
        call.enqueue(new MyCallBack(getContext()) {
            @Override
            protected void MyOnResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                HomeBanner homeBanner = gson.fromJson(response.body().string(), HomeBanner.class);
                //设置轮播图数据
                for (int i = 0; i < homeBanner.getData().getPlayer().size(); i++) {
                    bannerList.add(homeBanner.getData().getPlayer().get(i).getPhoto().getThumb());
                }
                banner.setImages(bannerList);
                banner.start();
                //设置促销单品的数据
                headAdapter.upData(homeBanner.getData().getPromote_goods());
            }
        });
        //获取首页商品列表的数据
        Call homeCall = instance.getCall(HOME_CATEGORY_URL);
        homeCall.enqueue(new MyCallBack(getContext()) {
            @Override
            protected void MyOnResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                HomeCategory homeCategory = gson.fromJson(response.body().string(), HomeCategory.class);
                lRecyclerAdapter.upData(homeCategory.getData());
            }
        });
    }


}

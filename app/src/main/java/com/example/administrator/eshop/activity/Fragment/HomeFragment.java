package com.example.administrator.eshop.activity.fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.adapter.BannerAdapter;
import com.example.administrator.eshop.activity.api.MyCallBack;
import com.example.administrator.eshop.activity.api.OkHttpUtil;
import com.example.administrator.eshop.activity.base.BaseFragment;
import com.example.administrator.eshop.activity.mode.Banner;
import com.example.administrator.eshop.activity.mode.HomeBannerRsp;
import com.example.administrator.eshop.activity.view.BannerLayout;
import com.example.administrator.eshop.activity.view.GlideImageLoader;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.view.CommonHeader;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/25.
 */

public class HomeFragment extends BaseFragment {
    private Toolbar standard_toolbar;
    private TextView standard_toolbar_title;
    private LRecyclerView lRecyclerView;
    private com.youth.banner.Banner banner;
    private ListView list_home_goods;
    private ViewPager viewPager;
    private LinearLayout linearPoint;
    private BannerLayout bannerLayout;
    private static final String HOME_URL = "http://106.14.32.204/eshop/emobile/?url=/home/data";
    private List images;
    private ImageView[] points;
    private BannerAdapter<Banner> bannerAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_recyclerview;
    }

    @Override
    public void initView(View view) {
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

        lRecyclerView = (LRecyclerView) view.findViewById(R.id.lrecyclerview_banner);
        addHeadView(view);
    }

    private void addHeadView(View view) {
        banner = (com.youth.banner.Banner) view.findViewById(R.id.banner);
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
        CommonHeader headerView = new CommonHeader(getActivity(), R.layout.home_recyclerview_head);
        mLRecyclerViewAdapter.addHeaderView(headerView);


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


    @Override
    public void initData() {

        Call call = OkHttpUtil.getInstance().getCall(HOME_URL);
        call.enqueue(new MyCallBack(getContext()) {
            @Override
            protected void MyOnResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                HomeBannerRsp homeBean = gson.fromJson(response.body().string(), HomeBannerRsp.class);
//                bannerAdapter.addData(homeBean.getData().getBanners());
//                bannerLayout.setBannerAdapter(bannerAdapter);
                Toast.makeText(getContext(), "成功了", Toast.LENGTH_SHORT).show();

            }
        });


    }


}

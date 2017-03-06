package com.example.administrator.eshop.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.adapter.SearchAdapter;
import com.example.administrator.eshop.activity.api.MyCallBack;
import com.example.administrator.eshop.activity.api.OkHttpUtil;
import com.example.administrator.eshop.activity.mode.Filter;
import com.example.administrator.eshop.activity.mode.Paginated;
import com.example.administrator.eshop.activity.mode.Pagination;
import com.example.administrator.eshop.activity.mode.SearchReq;
import com.example.administrator.eshop.activity.mode.SearchRsp;
import com.example.administrator.eshop.activity.mode.SimpleGoods;
import com.example.administrator.eshop.activity.mode.mymode.Search;
import com.example.administrator.eshop.activity.view.CustomSearchView;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/3.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private CustomSearchView searchView;
    private TextView text_is_hot, text_most_expensive, text_cheapest;
    private String stringExtra;
    private Filter filter;
    private Pagination pagination = new Pagination();
    private String SEARCH_URL = "http://106.14.32.204/eshop/emobile/?url=search";
    private LRecyclerView recyclerSearch;
    private SearchAdapter searchAdapter;
    private List searchList = new ArrayList();
    private String goodsPrice;
    private LRecyclerViewAdapter adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search_goods;
    }

    @Override
    public void initView() {
        searchView = (CustomSearchView) findViewById(R.id.search_view);
        text_is_hot = (TextView) findViewById(R.id.text_is_hot);
        text_is_hot.setActivated(true);
        text_is_hot.setOnClickListener(this);
        text_cheapest = (TextView) findViewById(R.id.text_cheapest);
        text_cheapest.setOnClickListener(this);
        text_most_expensive = (TextView) findViewById(R.id.text_most_expensive);
        text_most_expensive.setOnClickListener(this);
        recyclerSearch = (LRecyclerView) findViewById(R.id.lrecyclerview_search);
        recyclerSearch.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        searchAdapter = new SearchAdapter(this, searchList, new int[]{R.layout.item_search_goods});
        adapter = new LRecyclerViewAdapter(searchAdapter);
        recyclerSearch.setAdapter(adapter);
    }

    @Override
    public void initData() {

        stringExtra = getIntent().getStringExtra("key");
        filter = new Gson().fromJson(stringExtra, Filter.class);
        int i = filter.getCategoryId();
        Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
        getSearchData();
        searchView.setOnSearchListener(new CustomSearchView.OnSearchListener() {
            @Override
            public void search(String text) {
                filter.setKeywords(text);
                Toast.makeText(SearchActivity.this, text, Toast.LENGTH_SHORT).show();
                getSearchData();
            }
        });
        onRefreshAndLoad();

    }
    public void onRefreshAndLoad(){
        recyclerSearch.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                getSearchData();
                recyclerSearch.refreshComplete(0);
                adapter.notifyDataSetChanged();
            }
        });
        recyclerSearch.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                recyclerSearch.setFooterViewHint("加载更多","正在加载","网络不给力");
            }
        });


    }

    private void getSearchData() {
        SearchReq searchReq = new SearchReq();
        searchReq.setFilter(filter);
        searchReq.setPagination(pagination);
        Call call = OkHttpUtil.getInstance().postCall(SEARCH_URL, searchReq);
        call.enqueue(new MyCallBack(getApplicationContext()) {
            @Override
            protected void MyOnResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                SearchRsp searchGoods = gson.fromJson(response.body().string(), SearchRsp.class);
                searchAdapter.upData(searchGoods.getData());
                recyclerSearch.setAdapter(adapter);


            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_is_hot:
                goodsPrice = Filter.SORT_IS_HOT;
                text_is_hot.setActivated(true);
                text_cheapest.setActivated(false);
                text_most_expensive.setActivated(false);
                filter.setSortBy(goodsPrice);
                getSearchData();
                break;
            case R.id.text_cheapest:
                goodsPrice = Filter.SORT_PRICE_ASC;
                text_is_hot.setActivated(false);
                text_cheapest.setActivated(true);
                text_most_expensive.setActivated(false);
                filter.setSortBy(goodsPrice);
                getSearchData();
                break;
            case R.id.text_most_expensive:
                text_is_hot.setActivated(false);
                text_cheapest.setActivated(false);
                text_most_expensive.setActivated(true);
                goodsPrice = Filter.SORT_PRICE_DESC;
                filter.setSortBy(goodsPrice);
                getSearchData();
                break;
        }
    }
}

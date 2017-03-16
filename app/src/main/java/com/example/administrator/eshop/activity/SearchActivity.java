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
    private Paginated paginated;
    private Pagination pagination = new Pagination();
    private String SEARCH_URL = "http://106.14.32.204/eshop/emobile/?url=search";
    private LRecyclerView recyclerSearch;
    private SearchAdapter searchAdapter;
    private List searchList = new ArrayList();
    private String goodsPrice;
    private LRecyclerViewAdapter adapter;
    private SearchRsp searchRsp;
    private SearchReq searchReq;
    private Call postCall;
    private List<SimpleGoods> simpleGoodsList;
    private List<SimpleGoods> simpleGoodsList1;

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
        recyclerSearch.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        searchAdapter = new SearchAdapter(this, searchList, new int[]{R.layout.item_search_goods});
        adapter = new LRecyclerViewAdapter(searchAdapter);
        recyclerSearch.setAdapter(adapter);
    }

    @Override
    public void initData() {
        //获取Intent传递过来的数据
        stringExtra = getIntent().getStringExtra("key");
        //将json字符串转化对象
        filter = new Gson().fromJson(stringExtra, Filter.class);
        //加载recyclerView
        getSearchData(false);
        //搜索按钮的监听事件
        searchView.setOnSearchListener(new CustomSearchView.OnSearchListener() {
            @Override
            public void search(String text) {
                filter.setKeywords(text);
                Toast.makeText(SearchActivity.this, text, Toast.LENGTH_SHORT).show();
                getSearchData(false);
            }
        });
        //下拉刷新监听事件
        recyclerSearch.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                getSearchData(false);
                //加载0条数据，并隐藏下拉刷新视图
                recyclerSearch.refreshComplete(0);
                adapter.notifyDataSetChanged();
            }
        });
        //上拉加载监听事件
        recyclerSearch.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
//                searchAdapter.clear();
                setQuestParam(true);
                getSearchData(true);
                Toast.makeText(getApplicationContext(), "" + pagination.getPage(), Toast.LENGTH_SHORT).show();
//                recyclerSearch.refreshComplete(paginated.getCount());
//                adapter.notifyDataSetChanged();
            }
        });

    }

    public void setQuestParam(boolean isRefresh) {
        searchReq = new SearchReq();
        searchReq.setFilter(filter);
        if (isRefresh){
            if (pagination.isFirst()) {
                //页数加一
                pagination.next();
                //设置页数的请求参数
                searchReq.setPagination(pagination);
            }else {
                pagination.reset();
                //设置页数的请求参数
                searchReq.setPagination(pagination);
            }

        }

        }


    //获取网络数据
    private void getSearchData(boolean isLoadMore) {
        if (isLoadMore == false) {
            setQuestParam(false);
            postCall = OkHttpUtil.getInstance().postCall(SEARCH_URL, searchReq);
            postCall.enqueue(new MyCallBack(getApplicationContext()) {
                @Override
                protected void MyOnResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    searchRsp = gson.fromJson(response.body().string(), SearchRsp.class);
                    simpleGoodsList1 = searchRsp.getData();
                    searchAdapter.upData(simpleGoodsList1);
                }
            });
        } else {
            postCall = OkHttpUtil.getInstance().postCall(SEARCH_URL, searchReq);
            postCall.enqueue(new MyCallBack(getApplicationContext()) {
                @Override
                protected void MyOnResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    searchRsp = gson.fromJson(response.body().string(), SearchRsp.class);
                    paginated = searchRsp.getPaginated();
                    if (paginated.getCount() < paginated.getTotal()) {
                        simpleGoodsList = searchRsp.getData();
                        searchAdapter.addData(simpleGoodsList);
                    } else {
                        recyclerSearch.setNoMore(true);
                    }
                }
            });
        }
    }

    //顶部TextView选项监听事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_is_hot:
                goodsPrice = Filter.SORT_IS_HOT;
                text_is_hot.setActivated(true);//true为选中为激活状态
                text_cheapest.setActivated(false);//false为未选中状态
                text_most_expensive.setActivated(false);
                //设置排序方式的请求参数
                filter.setSortBy(goodsPrice);
                getSearchData(false);
                break;
            case R.id.text_cheapest:
                goodsPrice = Filter.SORT_PRICE_ASC;
                text_is_hot.setActivated(false);
                text_cheapest.setActivated(true);
                text_most_expensive.setActivated(false);
                filter.setSortBy(goodsPrice);
                getSearchData(false);
                break;
            case R.id.text_most_expensive:
                goodsPrice = Filter.SORT_PRICE_DESC;
                text_is_hot.setActivated(false);
                text_cheapest.setActivated(false);
                text_most_expensive.setActivated(true);
                filter.setSortBy(goodsPrice);
                getSearchData(false);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        postCall.cancel();
    }
}

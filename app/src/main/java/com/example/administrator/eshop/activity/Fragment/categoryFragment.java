package com.example.administrator.eshop.activity.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.MainActivity;
import com.example.administrator.eshop.activity.SearchActivity;
import com.example.administrator.eshop.activity.adapter.CategoryAdapter;
import com.example.administrator.eshop.activity.adapter.ChildrenAdapter;
import com.example.administrator.eshop.activity.api.MyCallBack;
import com.example.administrator.eshop.activity.api.OkHttpUtil;
import com.example.administrator.eshop.activity.base.BaseFragment;
import com.example.administrator.eshop.activity.mode.Filter;
import com.example.administrator.eshop.activity.mode.mymode.Category;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/2/23.
 */

public class CategoryFragment extends BaseFragment {
    private Toolbar standard_toolbar;
    //    private RecyclerView list_category, list_children;
    private ListView list_category, list_children;
    private TextView standard_toolbar_title;
    private CategoryAdapter caAdapter;
    private ChildrenAdapter chiAdapter;
    private List<Category.DataBean> categoryList;
    private List<Category.DataBean.ChildrenBean> chiList;
    public static final String URL = "http://106.14.32.204/eshop/emobile/?url=category";
    private Category category;
    private int goodsId;
    private int childrenGoodsId;
    private String string;

    @Override
    public void initView(View view) {
//        list_category = (RecyclerView) view.findViewById(R.id.list_category);
//        list_category.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        list_children = (RecyclerView) view.findViewById(R.id.list_children);
//        list_children.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        list_category = (ListView) view.findViewById(R.id.list_category);
        list_children = (ListView) view.findViewById(R.id.list_children);
        categoryList = new ArrayList<>();
        chiList = new ArrayList<>();
        caAdapter = new CategoryAdapter(getContext(), categoryList, new int[]{R.layout.item_primary_category});
        chiAdapter = new ChildrenAdapter(getContext(), chiList, new int[]{R.layout.item_children_category});
        list_category.setAdapter(caAdapter);
        list_children.setAdapter(chiAdapter);
        list_category.setItemChecked(0, true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void initToolbar(View view) {
        standard_toolbar = (Toolbar) view.findViewById(R.id.standard_toolbar);
        standard_toolbar_title = (TextView) view.findViewById(R.id.standard_toolbar_title);
        standard_toolbar_title.setText("分类");
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

    private void ChooseCategory() {
        //一级分类点击事件
        list_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                chiAdapter.upData(caAdapter.getItem(position).getChildren());
                list_children.setAdapter(chiAdapter);
            }
        });
        //二级分类点击事件
        list_children.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                childrenGoodsId = chiAdapter.getItem(position).getId();
                JumpSearch(childrenGoodsId);
            }
        });

    }


    @Override
    public void initData() {
        Call call = OkHttpUtil.getInstance().getCall(URL);
        call.enqueue(new MyCallBack(getContext()) {
            @Override
            protected void MyOnResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                category = null;
                try {
                    category = gson.fromJson(response.body().string(), Category.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                caAdapter.addData(category.getData());
                chiAdapter.addData(category.getData().get(0).getChildren());
                ChooseCategory();
            }
        });

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_category, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                int position = list_category.getCheckedItemPosition();
                goodsId = caAdapter.getItem(position).getId();
                JumpSearch(goodsId);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void JumpSearch(int goodsId) {
        Filter filter = new Filter();
        filter.setCategoryId(goodsId);
        string = new Gson().toJson(filter);
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("key", string);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}

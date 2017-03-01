package com.example.administrator.eshop.activity.mode;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryHome  {

    private int id;

    private String name;

    @SerializedName("goods")
    private List<SimpleGoods> mHotGoodsList; // 首页分类的推荐商品.

    public List<SimpleGoods> getHotGoodsList() {
        return mHotGoodsList;
    }
}

package com.example.administrator.eshop.activity.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.base.BaseViewHolder;
import com.example.administrator.eshop.activity.base.CommonAdapter;
import com.example.administrator.eshop.activity.mode.SimpleGoods;
import com.example.administrator.eshop.activity.mode.mymode.Search;

import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */

public class SearchAdapter extends CommonAdapter<SimpleGoods> {
    private List<SimpleGoods> list;
    private Context context;
    private int[] itemLayout;
    private String marketPrice;
    private SpannableString string;

    public SearchAdapter(Context context, List<SimpleGoods> list, int[] itemLayoutId) {
        super(context, list, itemLayoutId);
        this.context = context;
        this.list = list;
        this.itemLayout = itemLayoutId;
    }

    @Override
    public void setData(BaseViewHolder holder, SimpleGoods data, int viewType) {
        holder.setImageView(R.id.image_goods, data.getImg().getLarge());
        holder.setTextView(R.id.text_goods_name, data.getName());
        holder.setTextView(R.id.text_goods_price, data.getShopPrice());
        marketPrice = data.getMarketPrice();
        SpannableString string = new SpannableString(marketPrice);
        string.setSpan(new StrikethroughSpan(), 0, marketPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.setTextView(R.id.text_market_price, string);
    }
}

package com.example.administrator.eshop.activity.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.eshop.R;

/**
 * Created by Administrator on 2017/3/13.
 */

public class GoodsPopupWindow extends PopupWindow implements PopupWindow.OnDismissListener {
    private ViewGroup mParent;
    private ImageView image_goods;
    private TextView text_goods_price,text_inventory_value,text_number_value;
    private Button button_ok;

    private void GoodsPopupWindow(Activity activity) {
       mParent = (ViewGroup) activity.getWindow().getDecorView();
        View view = LayoutInflater.from(mParent.getContext()).inflate(R.layout.popup_goods_spec,mParent,false);
        image_goods = (ImageView) view.findViewById(R.id.image_goods);
        text_goods_price = (TextView) view.findViewById(R.id.text_goods_price);
        text_inventory_value = (TextView) view.findViewById(R.id.text_inventory_value);
        text_number_value = (TextView) view.findViewById(R.id.text_number_value);
        button_ok = (Button) view.findViewById(R.id.button_ok);


    }

    @Override
    public void onDismiss() {

    }
}

package com.example.administrator.eshop.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.eshop.R;

/**
 * Created by Administrator on 2017/3/7.
 */

public class CustomNumView extends RelativeLayout{
    private ImageView image_plus,image_minus;
    private TextView text_number;
    private int num;

    public CustomNumView(Context context) {
        this(context,null);
    }

    public CustomNumView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomNumView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.widget_simple_number_picker,this,true);
        image_plus = (ImageView) view.findViewById(R.id.image_plus);
        image_minus = (ImageView) view.findViewById(R.id.image_minus);
        text_number = (TextView) view.findViewById(R.id.text_number);
        num = Integer.valueOf(text_number.getText().toString());
        initView();
    }
    public void initView(){
        image_plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num=num+1;
                text_number.setText(num);
            }
        });
        image_minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num=num-1;
                text_number.setText(num);
            }
        });
    }
}

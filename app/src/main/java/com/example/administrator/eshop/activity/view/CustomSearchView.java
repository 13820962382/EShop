package com.example.administrator.eshop.activity.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.eshop.R;

/**
 * Created by Administrator on 2017/3/3.
 */

public class CustomSearchView extends LinearLayout implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener {

    private ImageButton button_search, button_clear;
    private EditText ediText_search;
    private OnSearchListener listener;
    private String text;

    public CustomSearchView(Context context) {
        this(context, null);
        initView(context);
    }


    public CustomSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView(context);
    }

    public CustomSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View searchView = LayoutInflater.from(context).inflate(R.layout.widget_simple_search_view, this);
        button_search = (ImageButton) searchView.findViewById(R.id.button_search);
        button_clear = (ImageButton) searchView.findViewById(R.id.button_clear);
        ediText_search = (EditText) searchView.findViewById(R.id.edit_query);
        ediText_search.addTextChangedListener(this);
        // 设置软键盘的操作：回车变成搜索的图标
        ediText_search.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        // 设置输入的类型：文本类型
        ediText_search.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        // 设置软键盘的操作事件监听
        ediText_search.setOnEditorActionListener(this);
        button_search.setOnClickListener(this);
        button_clear.setOnClickListener(this);
    }

    //ediText输入文本前触发的事件
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    // ediText输入文本时触发的事件
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    //ediText输入完之后触发的事件
    @Override
    public void afterTextChanged(Editable editable) {
        text = ediText_search.getText().toString();
        if (TextUtils.isEmpty(text)) {
            button_clear.setVisibility(INVISIBLE);
        } else {
            button_clear.setVisibility(VISIBLE);
        }
    }

    //imageButton的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_search:
                searchGoods();
                break;
            case R.id.button_clear:
                ediText_search.setText(null);

                break;
        }

    }

    public void searchGoods() {
        if (listener != null) {
            listener.search(text);
        }
        closeKeyBoard();
    }

    public void setOnSearchListener(OnSearchListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchGoods();
        }
        return false;
    }
    // 关闭软键盘
    private void closeKeyBoard() {

        // 失去焦点
        ediText_search.clearFocus();

        // 关闭软键盘
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(ediText_search.getWindowToken(),0);
    }

    public interface OnSearchListener {
        void search(String text);
    }
}

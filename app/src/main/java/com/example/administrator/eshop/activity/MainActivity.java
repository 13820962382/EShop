package com.example.administrator.eshop.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.fragment.CategoryFragment;
import com.example.administrator.eshop.activity.fragment.HomeFragment;
import com.example.administrator.eshop.activity.fragment.TestFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.tencent.bugly.crashreport.CrashReport;

public class MainActivity extends BaseActivity implements OnTabSelectListener {
    private FrameLayout layout_container;
    private BottomBar bottom_bar;
    private Fragment mHomeFragment, mCategoryFragment, mCartFragment, mSelfFragment;
    private Fragment currentFragment;
    private FragmentTransaction transaction;
    private boolean isFinish;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_eshop_main;
    }
    @Override
    public void initView() {
        setContentView(R.layout.activity_eshop_main);
        layout_container = (FrameLayout) findViewById(R.id.layout_container);
        bottom_bar = (BottomBar) findViewById(R.id.bottom_bar);
        bottom_bar.setOnTabSelectListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();

                }
                switchFragment(mHomeFragment);
                break;
            case R.id.tab_category:
                if (mCategoryFragment == null) {
                    mCategoryFragment = new CategoryFragment();

                }
                switchFragment(mCategoryFragment);
                break;
            case R.id.tab_cart:
                if (mCartFragment == null) {
                    mCartFragment = TestFragment.getInstance("cart");

                }
                switchFragment(mCartFragment);
                break;
            case R.id.tab_mine:
                if (mSelfFragment == null) {
                    mSelfFragment = TestFragment.getInstance("self");
                }
                switchFragment(mSelfFragment);
                break;
        }
    }

    public void switchFragment(Fragment target) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (currentFragment == target) {
            return;
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        if (target.isAdded()) {
            transaction.show(target);

        } else {
            transaction.add(R.id.layout_container, target);
        }

        transaction.commit();
        currentFragment = target;

    }

    @Override
    public void onBackPressed() {
        if (currentFragment != mHomeFragment) {
            //切换到首页上
            bottom_bar.selectTabWithId(R.id.tab_home);
        } else {
            finish();
        }

    }
}

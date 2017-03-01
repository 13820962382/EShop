package com.example.administrator.eshop.activity.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.RelativeLayout;

import com.example.administrator.eshop.R;
import com.example.administrator.eshop.activity.adapter.BannerAdapter;

import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Administrator on 2017/2/27.
 */

public class BannerLayout extends RelativeLayout {

    private Timer timer;
    private TimerTask timerTask;
    private ViewPager viewPager;
    private CircleIndicator interpolator;
    private long moveTime;
    private MyHandle handle;

    public BannerLayout(Context context) {
        super(context);
        init(context);
    }

    public BannerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BannerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
       View view =  LayoutInflater.from(context).inflate(R.layout.widget_banner_layout, this, true);
        viewPager = (ViewPager) view.findViewById(R.id.pager_banner);
        interpolator = (CircleIndicator) view.findViewById(R.id.indicator);
        handle = new MyHandle(this);

    }
    public void setBannerAdapter(BannerAdapter adapter){
        viewPager.setAdapter(adapter);
        interpolator.setViewPager(viewPager);
        adapter.registerDataSetObserver(interpolator.getDataSetObserver());

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
            handle.sendEmptyMessage(0);
            }
        };
        timer.schedule(timerTask,2000,2000);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        timer.cancel();
        timerTask.cancel();
        timer = null;
        timerTask = null;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        moveTime = System.currentTimeMillis()+2000;
        return super.dispatchTouchEvent(ev);
    }

    public static class MyHandle extends Handler {
        private WeakReference<BannerLayout> weakReference;

        public MyHandle(BannerLayout bannerLayout) {
            weakReference = new WeakReference<BannerLayout>(bannerLayout);
        }


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (weakReference == null) {
                return;
            }
            BannerLayout bannerLayout = weakReference.get();
            if (bannerLayout == null) {
                return;
            }
            if (System.currentTimeMillis() < bannerLayout.moveTime) {
                return;
            }
            bannerLayout.moveNext();
        }
    }

    public void moveNext() {
        int pagerCount;
        pagerCount = viewPager.getAdapter().getCount();
        if (viewPager.getAdapter()==null){
            throw new IllegalStateException("you need set a banner adapter");
        }
        if (viewPager.getCurrentItem()==pagerCount-1){
            viewPager.setCurrentItem(0,true);
        }else {
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
        }
    }
}

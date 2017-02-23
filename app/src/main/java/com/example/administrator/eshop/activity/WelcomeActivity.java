package com.example.administrator.eshop.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.administrator.eshop.R;

/**
 * Created by Administrator on 2017/2/22.
 */

public class WelcomeActivity extends AppCompatActivity implements Animator.AnimatorListener{
    private ImageView image_splash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        image_splash = (ImageView) findViewById(R.id.image_splash);

        image_splash.setAlpha(0.3f);
        image_splash.animate().alpha(1.0f).setDuration(2000).setListener(this).start();
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);

    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }
}

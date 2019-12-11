/*
 * project ：JunjieFinance
 * author : dluobida
 * class : SplashActivity.java
 * package : com.dluobida.junjiefinance.SplashActivity
 * currentModifyTime : 2019-10-29 22:40:18
 * lastModifyTime : 2019-10-29 22:40:17
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;


import com.dluobida.bluecat.finance.modules.main.ui.activity.MainActivity;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3F,1.0F);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        findViewById(R.id.tv_splash).startAnimation(alphaAnimation);
    }
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseApplication.java
 * package : com.dluobida.junjiefinance.base.application.BaseApplication
 * currentModifyTime : 2019-11-17 09:34:11
 * lastModifyTime : 2019-11-17 09:34:11
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.base.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.dluobida.bluecat.finance.core.rx.DataManager;
import com.dluobida.bluecat.finance.di.component.DaggerAppComponent;
import com.dluobida.bluecat.finance.di.module.AppModule;
import com.dluobida.bluecat.finance.utils.LogUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Inject
    public DataManager mDataManager;

    private static Context mContext;


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        DaggerAppComponent.builder().appModule(new AppModule(this))
                .build().inject(this);

        //初始化xlog
        LogUtils.init();
    }

    public static Context getContext(){
        return mContext;
    }
}

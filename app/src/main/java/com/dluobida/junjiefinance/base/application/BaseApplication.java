/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseApplication.java
 * package : com.dluobida.junjiefinance.base.application.BaseApplication
 * currentModifyTime : 2019-11-17 09:34:11
 * lastModifyTime : 2019-11-17 09:34:11
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.base.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.dluobida.junjiefinance.di.component.DaggerAppComponent;
import com.dluobida.junjiefinance.di.module.AppModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

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
    }

    public static Context getContext(){
        return mContext;
    }
}

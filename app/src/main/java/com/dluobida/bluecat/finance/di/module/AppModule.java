/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AppModule.java
 * package : com.dluobida.junjiefinance.di.module.AppModule
 * currentModifyTime : 2019-11-17 16:03:34
 * lastModifyTime : 2019-11-17 16:03:34
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.di.module;

import com.dluobida.bluecat.finance.base.application.BaseApplication;
import com.dluobida.bluecat.finance.core.db.DbHelper;
import com.dluobida.bluecat.finance.core.db.DbHelperImpl;
import com.dluobida.bluecat.finance.core.rx.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final BaseApplication mApplication;

    public AppModule(BaseApplication application){
        this.mApplication = application;
    }
    @Provides
    @Singleton
    BaseApplication provideApplicationContext(){
        return mApplication;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbHelperImpl dbHelperImpl){
        return dbHelperImpl;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DbHelper dbHelper){
        return new DataManager(dbHelper);
    }
}

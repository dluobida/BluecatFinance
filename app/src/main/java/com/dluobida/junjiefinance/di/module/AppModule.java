/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AppModule.java
 * package : com.dluobida.junjiefinance.di.module.AppModule
 * currentModifyTime : 2019-11-17 16:03:34
 * lastModifyTime : 2019-11-17 16:03:34
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.di.module;

import com.dluobida.junjiefinance.base.application.BaseApplication;
import com.dluobida.junjiefinance.core.db.DbHelper;
import com.dluobida.junjiefinance.core.db.DbHelperImpl;
import com.dluobida.junjiefinance.core.rx.DataManager;

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

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AppComponent.java
 * package : com.dluobida.junjiefinance.di.component.AppComponent
 * currentModifyTime : 2019-11-17 09:45:36
 * lastModifyTime : 2019-11-17 09:45:36
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.di.component;

import com.dluobida.bluecat.finance.base.application.BaseApplication;
import com.dluobida.bluecat.finance.di.module.AbstractAllActivityModule;
import com.dluobida.bluecat.finance.di.module.AbstractAllFragmentModule;
import com.dluobida.bluecat.finance.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AbstractAllFragmentModule.class,
        AppModule.class})
public interface AppComponent {
    void inject(BaseApplication baseApplication);
}

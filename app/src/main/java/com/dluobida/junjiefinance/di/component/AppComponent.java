/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AppComponent.java
 * package : com.dluobida.junjiefinance.di.component.AppComponent
 * currentModifyTime : 2019-11-17 09:45:36
 * lastModifyTime : 2019-11-17 09:45:36
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.di.component;

import com.dluobida.junjiefinance.base.application.BaseApplication;
import com.dluobida.junjiefinance.di.module.AbstractAllActivityModule;
import com.dluobida.junjiefinance.di.module.AbstractAllFragmentModule;
import com.dluobida.junjiefinance.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjection;
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

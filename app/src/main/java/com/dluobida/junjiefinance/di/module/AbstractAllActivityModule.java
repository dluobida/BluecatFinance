/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AbstractAllActivityModule.java
 * package : com.dluobida.junjiefinance.di.module.AbstractAllActivityModule
 * currentModifyTime : 2019-11-17 09:50:39
 * lastModifyTime : 2019-11-17 09:50:39
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.di.module;

import com.dluobida.junjiefinance.di.component.BaseActivityComponent;
import com.dluobida.junjiefinance.modules.expand.ui.activity.CreateExpandActivity;
import com.dluobida.junjiefinance.modules.main.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector(modules = CreateExpandActivityModule.class)
    abstract CreateExpandActivity contributesCreateExpandActivityInjector();
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseActivityComponent.java
 * package : com.dluobida.junjiefinance.di.component.BaseActivityComponent
 * currentModifyTime : 2019-11-17 09:51:43
 * lastModifyTime : 2019-11-17 09:51:43
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.di.component;

import com.dluobida.junjiefinance.base.activity.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {
    /**
     * 每一个继承于BaseActivity的Activity都继承于同一个子组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseActivity>{}
}

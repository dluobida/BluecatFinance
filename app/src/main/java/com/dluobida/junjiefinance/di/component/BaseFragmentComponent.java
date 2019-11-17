/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseFragmentComponent.java
 * package : com.dluobida.junjiefinance.di.component.BaseFragmentComponent
 * currentModifyTime : 2019-11-17 10:00:00
 * lastModifyTime : 2019-11-17 10:00:00
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.di.component;

import com.dluobida.junjiefinance.base.fragment.BaseFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {

    /**
     * 每一个继承于BaseFragment的Fragment都继承于同一个子组件
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseFragment>{

    }
}

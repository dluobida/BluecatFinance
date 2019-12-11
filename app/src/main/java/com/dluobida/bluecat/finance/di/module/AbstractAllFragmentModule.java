/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AbstractAllFragmentModule.java
 * package : com.dluobida.junjiefinance.di.module.AbstractAllFragmentModule
 * currentModifyTime : 2019-11-17 15:49:53
 * lastModifyTime : 2019-11-17 15:49:52
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.di.module;

import com.dluobida.bluecat.finance.di.component.BaseFragmentComponent;
import com.dluobida.bluecat.finance.modules.expand.ui.fragment.ExpandFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = ExpandFragmentModule.class)
    abstract ExpandFragment contributesHomePagerFragmentInject();
}

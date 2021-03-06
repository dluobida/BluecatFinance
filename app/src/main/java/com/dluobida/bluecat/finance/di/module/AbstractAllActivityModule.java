/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AbstractAllActivityModule.java
 * package : com.dluobida.junjiefinance.di.module.AbstractAllActivityModule
 * currentModifyTime : 2019-11-17 09:50:39
 * lastModifyTime : 2019-11-17 09:50:39
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.di.module;

import com.dluobida.bluecat.finance.di.component.BaseActivityComponent;
import com.dluobida.bluecat.finance.modules.assets.ui.activity.AccountDetailActivity;
import com.dluobida.bluecat.finance.modules.assets.ui.activity.CreateAccountActivity;
import com.dluobida.bluecat.finance.modules.expand.ui.activity.CreateExpandActivity;
import com.dluobida.bluecat.finance.modules.income.ui.activity.CreateIncomeActivity;
import com.dluobida.bluecat.finance.modules.main.ui.activity.MainActivity;
import com.dluobida.bluecat.finance.modules.transfer.ui.activity.CreateTransferActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector(modules = CreateExpandActivityModule.class)
    abstract CreateExpandActivity contributesCreateExpandActivityInjector();

    @ContributesAndroidInjector(modules = CreateAccountActivityModule.class)
    abstract CreateAccountActivity contributesCreateAccountActivityInjector();

    @ContributesAndroidInjector(modules = AccountDetailActivityModule.class)
    abstract AccountDetailActivity contributesAccountDetailActivityInjector();

    @ContributesAndroidInjector(modules = CreateIncomeActivityModule.class)
    abstract CreateIncomeActivity contributesCreateIncomeActivityInjector();

    @ContributesAndroidInjector(modules = CreateTransferActivityModule.class)
    abstract CreateTransferActivity contributesCreateTransferActivityInjector();
}

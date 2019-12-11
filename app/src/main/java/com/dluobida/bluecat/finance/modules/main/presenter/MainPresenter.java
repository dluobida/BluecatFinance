/*
 * project ：JunjieFinance
 * author : dluobida
 * class : MainPresenter.java
 * package : com.dluobida.junjiefinance.modules.main.ui.presenter.MainPresenter
 * currentModifyTime : 2019-11-04 22:45:05
 * lastModifyTime : 2019-11-04 22:45:04
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.main.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.modules.main.contract.MainContract;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    @Inject
    public MainPresenter() {

    }
}
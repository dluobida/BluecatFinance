/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BasePresenter.java
 * package : com.dluobida.junjiefinance.base.presenter.BasePresenter
 * currentModifyTime : 2019-11-04 22:49:41
 * lastModifyTime : 2019-11-04 22:49:41
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.base.presenter;

import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.rx.DataManager;

import javax.inject.Inject;

public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

    @Inject
    public DataManager mDataManager;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void reload() {

    }

    @Override
    public void registerEventBus() {

    }

    @Override
    public void unregisterEventBus() {

    }
}

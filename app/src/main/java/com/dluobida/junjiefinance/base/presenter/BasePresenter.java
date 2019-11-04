/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BasePresenter.java
 * package : com.dluobida.junjiefinance.base.presenter.BasePresenter
 * currentModifyTime : 2019-11-04 22:49:41
 * lastModifyTime : 2019-11-04 22:49:41
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.base.presenter;

import com.dluobida.junjiefinance.base.view.IView;

public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

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

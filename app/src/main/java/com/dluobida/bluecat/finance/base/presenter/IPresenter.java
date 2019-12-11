/*
 * project ：JunjieFinance
 * author : dluobida
 * class : IPresenter.java
 * package : com.dluobida.junjiefinance.base.presenter.IPresenter
 * currentModifyTime : 2019-10-31 22:27:07
 * lastModifyTime : 2019-10-31 22:27:06
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.base.presenter;

import com.dluobida.bluecat.finance.base.view.IView;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void detachView();

    void reload();

    void registerEventBus();

    void unregisterEventBus();
}

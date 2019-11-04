/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseActivity.java
 * package : com.dluobida.junjiefinance.base.activity.BaseActivity
 * currentModifyTime : 2019-10-30 22:45:05
 * lastModifyTime : 2019-10-30 22:45:05
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.base.activity;

import com.dluobida.junjiefinance.base.presenter.IPresenter;
import com.dluobida.junjiefinance.base.view.IView;

public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleActivity implements IView {

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}

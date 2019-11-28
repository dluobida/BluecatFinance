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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.dluobida.junjiefinance.base.presenter.IPresenter;
import com.dluobida.junjiefinance.base.view.IView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleActivity
        implements HasSupportFragmentInjector,IView {

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onViewCreated() {
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if(mPresenter != null){
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }
}

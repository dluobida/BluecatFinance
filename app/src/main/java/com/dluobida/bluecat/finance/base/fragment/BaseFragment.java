/*
 * project ：JunjieFinance
 * author : dluobida
 * class : BaseFragment.java
 * package : com.dluobida.junjiefinance.base.fragment.BaseFragment
 * currentModifyTime : 2019-11-05 23:09:41
 * lastModifyTime : 2019-11-05 23:09:41
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.classic.common.MultipleStatusView;
import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.utils.ToastUtils;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends IPresenter> extends AbstractSimpleFragment implements IView {
    @Inject
    protected T mPresenter;

    private MultipleStatusView mMultipleStatusView;

    @Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mPresenter != null){
            mPresenter.attachView(this);
        }

    }

    @Override
    public void onDestroyView() {
        if(mPresenter != null){
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mPresenter != null){
            mPresenter = null;
        }
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        ToastUtils.showToast(_mActivity,errorMsg);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}

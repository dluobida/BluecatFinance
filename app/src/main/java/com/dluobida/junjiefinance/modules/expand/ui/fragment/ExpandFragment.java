/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandFragment.java
 * package : com.dluobida.junjiefinance.modules.expand.ui.fragment.ExpandFragment
 * currentModifyTime : 2019-11-16 23:10:04
 * lastModifyTime : 2019-11-16 23:10:03
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.ui.fragment;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.fragment.BaseFragment;
import com.dluobida.junjiefinance.modules.expand.contract.ExpandContract;
import com.dluobida.junjiefinance.modules.expand.presenter.ExpandPresenter;

public class ExpandFragment extends BaseFragment<ExpandPresenter> implements ExpandContract.View{

    private static final String TAG = ExpandFragment.class.getSimpleName();

    public static ExpandFragment getInstance(){
        ExpandFragment instance = new ExpandFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expand;
    }

    @Override
    protected void initEventAndData() {

    }
}

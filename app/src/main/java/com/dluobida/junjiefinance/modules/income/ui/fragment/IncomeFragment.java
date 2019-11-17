/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.income.ui.fragment;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.fragment.BaseFragment;
import com.dluobida.junjiefinance.modules.income.contract.IncomeContract;
import com.dluobida.junjiefinance.modules.income.presenter.IncomePresenter;

public class IncomeFragment extends BaseFragment<IncomePresenter> implements  IncomeContract.View{
    private static final String TAG = IncomeFragment.class.getSimpleName();

    public static IncomeFragment getInstance(){
        IncomeFragment instance = new IncomeFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_income;
    }

    @Override
    protected void initEventAndData() {

    }
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.chart.ui.fragment;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.modules.assets.ui.fragment.AssetsFragment;
import com.dluobida.bluecat.finance.modules.chart.contract.ChartContract;
import com.dluobida.bluecat.finance.modules.chart.presenter.ChartPresenter;

public class ChartFragment extends BaseFragment<ChartPresenter> implements  ChartContract.View{
    private static final String TAG = AssetsFragment.class.getSimpleName();

    public static ChartFragment getInstance(){
        ChartFragment instance = new ChartFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chart;
    }

    @Override
    protected void initEventAndData() {

    }
}

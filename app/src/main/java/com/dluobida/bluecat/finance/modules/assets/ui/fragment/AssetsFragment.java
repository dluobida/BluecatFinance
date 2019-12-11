/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.ui.fragment;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.fragment.BaseFragment;
import com.dluobida.bluecat.finance.modules.assets.contract.AssetsContract;
import com.dluobida.bluecat.finance.modules.assets.presenter.AssetsPresenter;

public class AssetsFragment extends BaseFragment<AssetsPresenter> implements  AssetsContract.View{
    private static final String TAG = AssetsFragment.class.getSimpleName();

    public static AssetsFragment getInstance(){
        AssetsFragment instance = new AssetsFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_assets;
    }

    @Override
    protected void initEventAndData() {

    }
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsFragment.java
 * package : com.dluobida.junjiefinance.modules.income.ui.fragment.AssetsFragment
 * currentModifyTime : 2019-11-17 21:13:31
 * lastModifyTime : 2019-11-17 21:13:31
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.transfer.ui.fragment;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.fragment.BaseFragment;
import com.dluobida.junjiefinance.modules.assets.ui.fragment.AssetsFragment;
import com.dluobida.junjiefinance.modules.transfer.contract.TransferContract;
import com.dluobida.junjiefinance.modules.transfer.presenter.TransferPresenter;

public class TransferFragment extends BaseFragment<TransferPresenter> implements  TransferContract.View{
    private static final String TAG = AssetsFragment.class.getSimpleName();

    public static TransferFragment getInstance(){
        TransferFragment instance = new TransferFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_transfer;
    }

    @Override
    protected void initEventAndData() {

    }
}

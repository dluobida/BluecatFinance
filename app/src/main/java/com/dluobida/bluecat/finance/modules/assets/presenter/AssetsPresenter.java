/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsPresenter.java
 * package : com.dluobida.junjiefinance.modules.income.presenter.AssetsPresenter
 * currentModifyTime : 2019-11-17 21:10:20
 * lastModifyTime : 2019-11-17 21:10:20
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.modules.assets.contract.AssetsContract;

import java.util.List;

import javax.inject.Inject;

public class AssetsPresenter extends BasePresenter<AssetsContract.View> implements AssetsContract.Presenter{
    @Inject
    public AssetsPresenter(){

    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDataManager.queryAllAccountData();
    }
}

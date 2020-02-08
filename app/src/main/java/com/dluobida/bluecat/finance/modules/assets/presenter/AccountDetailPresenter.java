/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountDetailPresenter.java
 * package : com.dluobida.bluecat.finance.modules.assets.presenter.AccountDetailPresenter
 * currentModifyTime : 2020-02-08 11:48:47
 * lastModifyTime : 2020-02-08 11:48:47
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.modules.assets.contract.AccountDetailContract;

import java.util.List;

import javax.inject.Inject;

public class AccountDetailPresenter extends BasePresenter<AccountDetailContract.View> implements AccountDetailContract.Presenter {

    @Inject
    public AccountDetailPresenter(){

    }

    @Override
    public void saveAccountData(AccountData accountData) {
        mDataManager.saveAccountData(accountData);
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDataManager.queryAllAccountData();
    }
}

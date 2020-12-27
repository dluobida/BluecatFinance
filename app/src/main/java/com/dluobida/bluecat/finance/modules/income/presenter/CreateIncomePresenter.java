/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateIncomePresenter.java
 * package : com.dluobida.bluecat.finance.modules.income.presenter.CreateIncomePresenter
 * currentModifyTime : 2020-12-16 21:27:09
 * lastModifyTime : 2020-12-16 21:27:08
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.constant.MathMoneyEnum;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.contract.CreateIncomeContract;

import java.util.List;

import javax.inject.Inject;

public class CreateIncomePresenter extends BasePresenter<CreateIncomeContract.View>
        implements CreateIncomeContract.Presenter{
    @Inject
    CreateIncomePresenter(){

    }


    @Override
    public void saveIncomeData(IncomeData imcomeData) {
        //1.在收入表中增加一行
        mDataManager.saveIncomeData(imcomeData);
        //在账户表中更新相关的金额
        mDataManager.updataAllAccountByJava();



    }

    @Override
    public void deleteIncomeData(Long id) {
        mDataManager.deleteIncomeData(id);
    }

    @Override
    public List<IncomeData> queryAllIncomeData() {
        return mDataManager.queryAllIncomeData();
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDataManager.queryAllAccountData();
    }

}

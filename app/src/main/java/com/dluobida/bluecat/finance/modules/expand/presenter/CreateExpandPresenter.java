/*
 * project ：JunjieFinance
 * author : dluobida
 * class : CreateExpandPresenter.java
 * package : com.dluobida.junjiefinance.modules.expand.presenter.CreateExpandPresenter
 * currentModifyTime : 2019-12-08 16:30:04
 * lastModifyTime : 2019-12-08 16:30:03
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.constant.MathMoneyEnum;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.contract.CreateExpandContract;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.MathMoneyUtils;

import java.util.List;

import javax.inject.Inject;

public class CreateExpandPresenter extends BasePresenter<CreateExpandContract.View>
        implements CreateExpandContract.Presenter {
    @Inject
    CreateExpandPresenter(){

    }


    @Override
    public void saveExpandData(ExpandData expandData) {
        //1.在支出表中增加一行
        mDataManager.saveExpandData(expandData);
        //在账户表中更新相关的金额
        mDataManager.updateAccountData(expandData.getAccount(),expandData.getMoney(), MathMoneyEnum.SUB);

    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDataManager.queryAllExpandData();
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDataManager.queryAllAccountData();
    }
}

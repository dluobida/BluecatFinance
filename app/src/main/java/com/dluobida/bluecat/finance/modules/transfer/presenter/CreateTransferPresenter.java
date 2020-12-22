/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateTransferPresenter.java
 * package : com.dluobida.bluecat.finance.modules.transfer.presenter.CreateTransferPresenter
 * currentModifyTime : 2020-12-17 23:09:15
 * lastModifyTime : 2020-12-16 22:37:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.constant.MathMoneyEnum;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.modules.transfer.contract.CreateTransferContract;

import java.util.List;

import javax.inject.Inject;

public class CreateTransferPresenter extends BasePresenter<CreateTransferContract.View>
        implements CreateTransferContract.Presenter{
    @Inject
    CreateTransferPresenter(){

    }


    @Override
    public void saveTransferData(TransferData transferData) {
        //1.在收入表中增加一行
        mDataManager.saveTransferData(transferData);
        //在账户表中更新相关的金额
        mDataManager.updateAccountData(transferData.getAccountIn(),transferData.getMoney(), MathMoneyEnum.ADD);
        mDataManager.updateAccountData(transferData.getAccountOut(),transferData.getMoney(),MathMoneyEnum.SUB);

    }

    @Override
    public List<TransferData> queryAllTransferData() {
        return mDataManager.queryAllTransferData();
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDataManager.queryAllAccountData();
    }

}

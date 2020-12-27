/*
 * project ：JunjieFinance
 * author : dluobida
 * class : DataManager.java
 * package : com.dluobida.junjiefinance.core.rx.DataManager
 * currentModifyTime : 2019-11-28 22:34:49
 * lastModifyTime : 2019-11-28 22:34:49
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.core.rx;

import com.dluobida.bluecat.finance.core.constant.MathMoneyEnum;
import com.dluobida.bluecat.finance.core.db.DbHelper;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.core.db.table.TransferData;

import java.util.List;

public class DataManager implements DbHelper {
    private DbHelper mDbHelper;

    public DataManager(DbHelper mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    @Override
    public void saveExpandData(ExpandData expandData) {
        mDbHelper.saveExpandData(expandData);

    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDbHelper.queryAllExpandData();
    }

    @Override
    public List<ExpandData> queryExpandDataByDate(String date) {
        return mDbHelper.queryExpandDataByDate(date);
    }

    @Override
    public void deleteExpandData(Long id) {
        mDbHelper.deleteExpandData(id);
    }

    @Override
    public void saveIncomeData(IncomeData incomeData) {
        mDbHelper.saveIncomeData(incomeData);
    }

    @Override
    public List<IncomeData> queryAllIncomeData() {
        return mDbHelper.queryAllIncomeData();
    }

    @Override
    public void deleteIncomeData(Long id) {
        mDbHelper.deleteIncomeData(id);
    }

    @Override
    public void saveTransferData(TransferData transferData) {
        mDbHelper.saveTransferData(transferData);
    }

    @Override
    public List<TransferData> queryAllTransferData() {
        return mDbHelper.queryAllTransferData();
    }

    @Override
    public void saveAccountData(AccountData accountData) {
        mDbHelper.saveAccountData(accountData);
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return mDbHelper.queryAllAccountData();
    }

    @Override
    public void updateAccountData(String accountName, String money, MathMoneyEnum type) {
        mDbHelper.updateAccountData(accountName,money,type);
    }

    @Override
    public void updataAllAccountByJava() {
        mDbHelper.updataAllAccountByJava();
    }
}

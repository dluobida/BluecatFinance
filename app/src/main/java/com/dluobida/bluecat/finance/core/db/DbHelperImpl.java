/*
 * project ：JunjieFinance
 * author : dluobida
 * class : DbHelperImpl.java
 * package : com.dluobida.junjiefinance.core.db.DbHelperImpl
 * currentModifyTime : 2019-11-27 23:10:09
 * lastModifyTime : 2019-11-27 23:10:09
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.core.db;

import android.database.sqlite.SQLiteDatabase;

import com.dluobida.bluecat.finance.base.application.BaseApplication;
import com.dluobida.bluecat.finance.core.constant.Constants;
import com.dluobida.bluecat.finance.core.constant.MathMoneyEnum;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.core.greendao.DaoMaster;
import com.dluobida.bluecat.finance.core.greendao.DaoSession;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.MathMoneyUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;

    @Inject
    DbHelperImpl() {
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper =
                new DaoMaster.DevOpenHelper(BaseApplication.getContext(), Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

    }


    @Override
    public void saveExpandData(ExpandData expandData) {
        daoSession.getExpandDataDao().save(expandData);
    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        List<ExpandData> expandDatas = daoSession.getExpandDataDao().loadAll();
        Collections.sort(expandDatas, new Comparator<ExpandData>() {
            @Override
            public int compare(ExpandData o1, ExpandData o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        return expandDatas;
    }

    @Override
    public List<ExpandData> queryExpandDataByDate(String date) {
        List<ExpandData> expandDatas = daoSession.getExpandDataDao().queryRaw("where date=?", date);
        return expandDatas;
    }

    @Override
    public void deleteExpandData(Long id) {
        daoSession.getExpandDataDao().deleteByKey(id);
    }

    @Override
    public void saveIncomeData(IncomeData incomeData) {
        daoSession.getIncomeDataDao().save(incomeData);
    }

    @Override
    public List<IncomeData> queryAllIncomeData() {

        List<IncomeData> expandDatas = daoSession.getIncomeDataDao().loadAll();
        Collections.sort(expandDatas, new Comparator<IncomeData>() {
            @Override
            public int compare(IncomeData o1, IncomeData o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        return daoSession.getIncomeDataDao().loadAll();
    }

    @Override
    public void deleteIncomeData(Long id) {
        daoSession.getIncomeDataDao().deleteByKey(id);
    }

    @Override
    public void saveTransferData(TransferData transferData) {
        daoSession.getTransferDataDao().save(transferData);
    }

    @Override
    public List<TransferData> queryAllTransferData() {
        return daoSession.getTransferDataDao().loadAll();
    }

    @Override
    public void saveAccountData(AccountData accountData) {
        daoSession.getAccountDataDao().save(accountData);
    }

    @Override
    public List<AccountData> queryAllAccountData() {
        return daoSession.getAccountDataDao().loadAll();
    }

    @Override
    public void updateAccountData(String accountName, String money, MathMoneyEnum type) {
        List<AccountData> datas = daoSession.getAccountDataDao().queryRaw("where name=?", accountName);
        LogUtils.i("accountData=" + datas.toString());
        AccountData updateAccountData = datas.get(0);
        LogUtils.i("originMoney=" + updateAccountData.getMoney() + " expandMoney=" + money);
        String updateMoney = "";
        if(type == MathMoneyEnum.ADD){
            updateMoney = MathMoneyUtils.add(updateAccountData.getMoney(), money);
        }else {
            updateMoney = MathMoneyUtils.sub(updateAccountData.getMoney(), money);
        }
        LogUtils.i("updateMoney=" + updateMoney);
        updateAccountData.setMoney(updateMoney);
        daoSession.getAccountDataDao().update(updateAccountData);

    }

    @Override
    public void updataAllAccountByJava() {
        List<AccountData> allAccount = daoSession.getAccountDataDao().loadAll();
        for(AccountData account : allAccount){
            String accountName = account.getName();
            //获取该账号所有的支出
            List<ExpandData> expandDatas = daoSession.getExpandDataDao().queryRaw("where account=?", accountName);
            //计算总和
            String allExpand="0";
            for(ExpandData expand : expandDatas){
                allExpand = MathMoneyUtils.add(allExpand,expand.getMoney());
            }
            //获取该账号所有的收入
            List<IncomeData> incomeDatas = daoSession.getIncomeDataDao().queryRaw("where account=?", accountName);
            //计算总和
            String allIncome="0";
            for(IncomeData income : incomeDatas){
                allIncome = MathMoneyUtils.add(allIncome,income.getMoney());
            }
            String newAccount = MathMoneyUtils.add(account.getOriginMoney(),allIncome);
            newAccount = MathMoneyUtils.sub(newAccount,allExpand);
            account.setMoney(newAccount);
            daoSession.getAccountDataDao().update(account);
        }

    }

}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : MainPresenter.java
 * package : com.dluobida.junjiefinance.modules.main.ui.presenter.MainPresenter
 * currentModifyTime : 2019-11-04 22:45:05
 * lastModifyTime : 2019-11-04 22:45:04
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.main.presenter;

import android.os.Environment;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.modules.main.contract.MainContract;
import com.dluobida.bluecat.finance.utils.ExcelUtil;
import com.dluobida.bluecat.finance.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    @Inject
    public MainPresenter() {

    }

    @Override
    public void backSync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String filePath = Environment.getExternalStorageDirectory() +  "/bluecat.xls";
                LogUtils.i(filePath);
                //保存支出表
                String[] sheetNames = {"支出", "收入", "转账","资产"};
                List<String[]> colNames = new ArrayList<>();
                String[] expandTitle = {"id", "date", "money","catagroy","account","remark"};
                colNames.add(expandTitle);
                String[] imcomeTitle = {"id", "date", "money","catagroy","account","remark"};
                colNames.add(imcomeTitle);
                String[] transferTitle = {"id", "date", "money","accountOut","accountIn","remark"};
                colNames.add(transferTitle);
                String[] accountTitle = {"id", "name", "money","originMoney","remark","accountType"};
                colNames.add(accountTitle);
                ExcelUtil.initExcel(filePath,sheetNames,colNames);
                ExcelUtil.writeObjListToExcel(mDataManager.queryAllExpandData(), filePath, 0);
                ExcelUtil.writeObjListToExcel(mDataManager.queryAllIncomeData(), filePath, 1);
                ExcelUtil.writeObjListToExcel(mDataManager.queryAllTransferData(), filePath, 2);
                ExcelUtil.writeObjListToExcel(mDataManager.queryAllAccountData(), filePath, 3);
            }
        }).start();
    }
}

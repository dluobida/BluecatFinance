/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsPresenter.java
 * package : com.dluobida.junjiefinance.modules.income.presenter.AssetsPresenter
 * currentModifyTime : 2019-11-17 21:10:20
 * lastModifyTime : 2019-11-17 21:10:20
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.bean.IncomeListData;
import com.dluobida.bluecat.finance.modules.income.contract.IncomeContract;

import java.util.List;

import javax.inject.Inject;

public class IncomePresenter extends BasePresenter<IncomeContract.View> implements IncomeContract.Presenter{
    private int currentPage = 0;
    private boolean isRefresh = true;
    @Inject
    public IncomePresenter(){

    }

    @Override
    public List<IncomeData> queryAllIncomeData() {
        return mDataManager.queryAllIncomeData();
    }

    @Override
    public void getIncomeListData(boolean isShowStatusView) {
        List<IncomeData> datas = mDataManager.queryAllIncomeData();
        IncomeListData showData = new IncomeListData();
        showData.setDatas(datas);
        showData.setCurPage(currentPage);
        mView.showIncomeListData(showData,isRefresh);
    }

    @Override
    public void refreshLayout(boolean isShowStatusView) {
        isRefresh = true;
        currentPage = 0;
        getIncomeListData(isShowStatusView);
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        currentPage++;
//        getIncomeListData(false);

    }
}

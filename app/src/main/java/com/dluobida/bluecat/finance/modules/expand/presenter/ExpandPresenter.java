/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandPresenter.java
 * package : com.dluobida.junjiefinance.modules.expand.presenter.ExpandPresenter
 * currentModifyTime : 2019-11-16 23:17:37
 * lastModifyTime : 2019-11-16 23:17:36
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData;
import com.dluobida.bluecat.finance.modules.expand.contract.ExpandContract;
import com.dluobida.bluecat.finance.utils.DateUtils;
import com.dluobida.bluecat.finance.utils.MathMoneyUtils;

import java.util.List;

import javax.inject.Inject;

public class ExpandPresenter extends BasePresenter<ExpandContract.View> implements ExpandContract.Presenter{
    private int currentPage = 0;
    private boolean isRefresh = true;

    @Inject
    public ExpandPresenter(){

    }


    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDataManager.queryAllExpandData();
    }

    @Override
    public void getExpandListData(boolean isShowStatusView) {
        List<ExpandData> datas = mDataManager.queryAllExpandData();
        ExpandListData showData = new ExpandListData();
        showData.setDatas(datas);
        showData.setCurPage(currentPage);
        mView.showExpandListData(showData,isRefresh);
    }

    @Override
    public void refreshLayout(boolean isShowStatusView) {
        isRefresh = true;
        currentPage = 0;
        getExpandListData(isShowStatusView);

    }

    @Override
    public void loadMore() {
        isRefresh = false;
        currentPage++;
//        getExpandListData(false);
    }

    @Override
    public void getCurrentExpandMoney() {
        List<ExpandData> datas = mDataManager.queryExpandDataByDate(DateUtils.getNowDate());
        String totalMoney = "0";
        for (ExpandData expandData : datas){
            totalMoney = MathMoneyUtils.add(totalMoney,expandData.getMoney());
        }
        mView.showCurrentExpandMoney(totalMoney);
    }
}

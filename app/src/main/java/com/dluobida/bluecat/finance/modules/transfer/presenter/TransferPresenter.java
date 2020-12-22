/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsPresenter.java
 * package : com.dluobida.junjiefinance.modules.income.presenter.AssetsPresenter
 * currentModifyTime : 2019-11-17 21:10:20
 * lastModifyTime : 2019-11-17 21:10:20
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.presenter;

import com.dluobida.bluecat.finance.base.presenter.BasePresenter;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.modules.transfer.bean.TransferListData;
import com.dluobida.bluecat.finance.modules.transfer.contract.TransferContract;

import java.util.List;

import javax.inject.Inject;

public class TransferPresenter extends BasePresenter<TransferContract.View> implements TransferContract.Presenter{
    private int currentPage = 0;
    private boolean isRefresh = true;
    @Inject
    public TransferPresenter(){

    }

    @Override
    public List<TransferData> queryAllTransferData() {
        return mDataManager.queryAllTransferData();
    }

    @Override
    public void getTransferListData(boolean isShowStatusView) {
        List<TransferData> datas = mDataManager.queryAllTransferData();
        TransferListData showData = new TransferListData();
        showData.setDatas(datas);
        showData.setCurPage(currentPage);
        mView.showTransferListData(showData,isRefresh);
    }

    @Override
    public void refreshLayout(boolean isShowStatusView) {
        isRefresh = true;
        currentPage = 0;
        getTransferListData(isShowStatusView);

    }

    @Override
    public void loadMore() {
        isRefresh = false;
        currentPage++;
//        getTransferListData(false);

    }
}

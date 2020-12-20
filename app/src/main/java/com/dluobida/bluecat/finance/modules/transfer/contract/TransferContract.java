/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsContract.java
 * package : com.dluobida.junjiefinance.modules.income.contract.AssetsContract
 * currentModifyTime : 2019-11-17 21:09:05
 * lastModifyTime : 2019-11-17 21:09:04
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.modules.transfer.bean.TransferListData;

import java.util.List;

public interface TransferContract {
    interface View extends IView {
        void showTransferListData(TransferListData transferListData, boolean isRefresh);
    }

    interface Presenter extends IPresenter<View> {
        List<TransferData> queryAllTransferData();
        void getTransferListData(boolean isShowStatusView);
        void refreshLayout(boolean isShowStatusView);
        void loadMore();
    }
}

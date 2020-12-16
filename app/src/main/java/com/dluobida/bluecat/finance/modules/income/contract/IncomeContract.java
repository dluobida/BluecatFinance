/*
 * project ：JunjieFinance
 * author : dluobida
 * class : AssetsContract.java
 * package : com.dluobida.junjiefinance.modules.income.contract.AssetsContract
 * currentModifyTime : 2019-11-17 21:09:05
 * lastModifyTime : 2019-11-17 21:09:04
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.bean.IncomeListData;

import java.util.List;

public interface IncomeContract {
    interface View extends IView {
        void showIncomeListData(IncomeListData incomeListData, boolean isRefresh);

    }

    interface Presenter extends IPresenter<View> {
        List<IncomeData> queryAllIncomeData();
        void getIncomeListData(boolean isShowStatusView);
        void refreshLayout(boolean isShowStatusView);
        void loadMore();

    }
}

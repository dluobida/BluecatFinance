/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandContract.java
 * package : com.dluobida.junjiefinance.modules.expand.contract.ExpandContract
 * currentModifyTime : 2019-11-16 23:12:35
 * lastModifyTime : 2019-11-16 23:12:34
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData;

import java.util.List;

public interface ExpandContract {
    interface View extends IView{
       void showExpandListData(ExpandListData expandListData,boolean isRefresh);
       void showCurrentExpandMoney(String money);

    }

    interface Presenter extends IPresenter<View>{
        List<ExpandData> queryAllExpandData();
        void getExpandListData(boolean isShowStatusView);
        void refreshLayout(boolean isShowStatusView);
        void loadMore();
        void getCurrentExpandMoney();

    }


}

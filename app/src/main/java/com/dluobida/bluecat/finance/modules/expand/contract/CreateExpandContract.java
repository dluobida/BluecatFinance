/*
 * project ：JunjieFinance
 * author : dluobida
 * class : CreateExpandContract.java
 * package : com.dluobida.junjiefinance.modules.expand.contract.CreateExpandContract
 * currentModifyTime : 2019-12-08 16:31:56
 * lastModifyTime : 2019-12-08 16:31:56
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;

import java.util.List;

public interface CreateExpandContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        void saveExpandData(ExpandData expandData);

        void deleteExpandDataById(Long id);

        List<AccountData> queryAllAccountData();

    }
}

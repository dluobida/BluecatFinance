/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountDetailContract.java
 * package : com.dluobida.bluecat.finance.modules.assets.contract.AccountDetailContract
 * currentModifyTime : 2020-02-08 11:49:26
 * lastModifyTime : 2020-02-08 11:49:26
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.AccountData;

import java.util.List;

public interface AccountDetailContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        void saveAccountData(AccountData accountData);
        List<AccountData> queryAllAccountData();

    }
}

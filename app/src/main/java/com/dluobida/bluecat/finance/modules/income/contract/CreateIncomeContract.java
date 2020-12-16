/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateIncomeContract.java
 * package : com.dluobida.bluecat.finance.modules.income.contract.CreateIncomeContract
 * currentModifyTime : 2020-12-16 21:29:16
 * lastModifyTime : 2020-12-16 21:29:15
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;

import java.util.List;

public interface CreateIncomeContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        void saveIncomeData(IncomeData expandData);

        List<IncomeData> queryAllIncomeData();

        List<AccountData> queryAllAccountData();
    }
}

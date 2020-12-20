/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateTransferContract.java
 * package : com.dluobida.bluecat.finance.modules.transfer.contract.CreateTransferContract
 * currentModifyTime : 2020-12-17 23:08:15
 * lastModifyTime : 2020-12-16 22:37:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.TransferData;

import java.util.List;

public interface CreateTransferContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        void saveTransferData(TransferData expandData);

        List<TransferData> queryAllTransferData();

        List<AccountData> queryAllAccountData();
    }
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : MainContract.java
 * package : com.dluobida.junjiefinance.modules.main.ui.contract.MainContract
 * currentModifyTime : 2019-11-04 22:45:48
 * lastModifyTime : 2019-11-04 22:45:48
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.main.contract;

import com.dluobida.bluecat.finance.base.presenter.IPresenter;
import com.dluobida.bluecat.finance.base.view.IView;

public interface MainContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View> {
       void backSync();
    }
}

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
import com.dluobida.bluecat.finance.core.greendao.ExpandData;

import java.util.List;

public interface ExpandContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        List<ExpandData> queryAllExpandData();

    }


}

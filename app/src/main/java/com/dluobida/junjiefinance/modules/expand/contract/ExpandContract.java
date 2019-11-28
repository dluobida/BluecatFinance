/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandContract.java
 * package : com.dluobida.junjiefinance.modules.expand.contract.ExpandContract
 * currentModifyTime : 2019-11-16 23:12:35
 * lastModifyTime : 2019-11-16 23:12:34
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.contract;

import com.dluobida.junjiefinance.base.presenter.IPresenter;
import com.dluobida.junjiefinance.base.view.IView;
import com.dluobida.junjiefinance.core.greendao.ExpandData;

import java.util.List;

public interface ExpandContract {
    interface View extends IView{

    }

    interface Presenter extends IPresenter<View>{
        void saveExpandData(ExpandData expandData);

        List<ExpandData> queryAllExpandData();

    }


}

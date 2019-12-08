/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandPresenter.java
 * package : com.dluobida.junjiefinance.modules.expand.presenter.ExpandPresenter
 * currentModifyTime : 2019-11-16 23:17:37
 * lastModifyTime : 2019-11-16 23:17:36
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.presenter;

import com.dluobida.junjiefinance.base.presenter.BasePresenter;
import com.dluobida.junjiefinance.core.greendao.ExpandData;
import com.dluobida.junjiefinance.modules.expand.contract.ExpandContract;

import java.util.List;

import javax.inject.Inject;

public class ExpandPresenter extends BasePresenter<ExpandContract.View> implements ExpandContract.Presenter{
    @Inject
    public ExpandPresenter(){

    }


    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDataManager.queryAllExpandData();
    }
}

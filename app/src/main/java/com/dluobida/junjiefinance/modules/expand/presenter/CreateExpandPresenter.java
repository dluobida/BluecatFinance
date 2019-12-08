/*
 * project ：JunjieFinance
 * author : dluobida
 * class : CreateExpandPresenter.java
 * package : com.dluobida.junjiefinance.modules.expand.presenter.CreateExpandPresenter
 * currentModifyTime : 2019-12-08 16:30:04
 * lastModifyTime : 2019-12-08 16:30:03
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.presenter;

import com.dluobida.junjiefinance.base.presenter.BasePresenter;
import com.dluobida.junjiefinance.core.greendao.ExpandData;
import com.dluobida.junjiefinance.modules.expand.contract.CreateExpandContract;
import com.dluobida.junjiefinance.modules.main.contract.MainContract;

import java.util.List;

import javax.inject.Inject;

public class CreateExpandPresenter extends BasePresenter<CreateExpandContract.View>
        implements CreateExpandContract.Presenter {
    @Inject
    CreateExpandPresenter(){

    }


    @Override
    public void saveExpandData(ExpandData expandData) {
        mDataManager.saveExpandData(expandData);

    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDataManager.queryAllExpandData();
    }
}

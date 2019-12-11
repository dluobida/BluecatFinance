/*
 * project ：JunjieFinance
 * author : dluobida
 * class : DataManager.java
 * package : com.dluobida.junjiefinance.core.rx.DataManager
 * currentModifyTime : 2019-11-28 22:34:49
 * lastModifyTime : 2019-11-28 22:34:49
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.core.rx;

import com.dluobida.bluecat.finance.core.db.DbHelper;
import com.dluobida.bluecat.finance.core.greendao.ExpandData;

import java.util.List;

public class DataManager implements DbHelper {
    private DbHelper mDbHelper;

    public DataManager(DbHelper mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    @Override
    public void saveExpandData(ExpandData expandData) {
        mDbHelper.saveExpandData(expandData);

    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        return mDbHelper.queryAllExpandData();
    }
}

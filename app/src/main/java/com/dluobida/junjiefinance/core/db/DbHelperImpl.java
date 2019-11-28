/*
 * project ：JunjieFinance
 * author : dluobida
 * class : DbHelperImpl.java
 * package : com.dluobida.junjiefinance.core.db.DbHelperImpl
 * currentModifyTime : 2019-11-27 23:10:09
 * lastModifyTime : 2019-11-27 23:10:09
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.core.db;

import android.database.sqlite.SQLiteDatabase;

import com.dluobida.junjiefinance.base.application.BaseApplication;
import com.dluobida.junjiefinance.core.constant.Constants;
import com.dluobida.junjiefinance.core.greendao.DaoMaster;
import com.dluobida.junjiefinance.core.greendao.DaoSession;
import com.dluobida.junjiefinance.core.greendao.ExpandData;

import java.util.List;

import javax.inject.Inject;

public class DbHelperImpl implements DbHelper{

    private DaoSession daoSession;
    @Inject
    DbHelperImpl(){
        initGreenDao();
    }

    private void initGreenDao(){
        DaoMaster.DevOpenHelper devOpenHelper =
                new DaoMaster.DevOpenHelper(BaseApplication.getContext(), Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();

    }


    @Override
    public void saveExpandData(ExpandData expandData) {
        daoSession.getExpandDataDao().insert(expandData);
    }

    @Override
    public List<ExpandData> queryAllExpandData() {
        return daoSession.getExpandDataDao().loadAll();
    }

}

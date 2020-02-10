/*
 * project ：JunjieFinance
 * author : dluobida
 * class : DbHelper.java
 * package : com.dluobida.junjiefinance.core.db.DbHelper
 * currentModifyTime : 2019-11-27 23:06:24
 * lastModifyTime : 2019-11-27 23:06:24
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.core.db;

import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;

import java.util.List;

public interface DbHelper {

    /**
     * 保存支出数据
     * @param expandData
     */
    void saveExpandData(ExpandData expandData);

    /**
     * 查询所有的支出数据
     * @return
     */
    List<ExpandData> queryAllExpandData();

    /**
     * 创建新账户
     * @param accountData
     */
    void saveAccountData(AccountData accountData);

    /**
     * 查询所有账户数据
     * @return
     */
    List<AccountData> queryAllAccountData();

    void updateAccountData(String accountName,String money);
}

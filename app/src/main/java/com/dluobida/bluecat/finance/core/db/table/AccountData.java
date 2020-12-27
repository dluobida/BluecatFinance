/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountData.java
 * package : com.dluobida.bluecat.finance.core.db.table.AccountData
 * currentModifyTime : 2020-02-08 10:05:58
 * lastModifyTime : 2020-02-08 09:50:29
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.core.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 账户表
 */
@Entity
public class AccountData {
    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String money;

    private String originMoney;

    private String remark;

    private String accountType;

    @Generated(hash = 1536521423)
    public AccountData(Long id, String name, String money, String originMoney,
            String remark, String accountType) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.originMoney = originMoney;
        this.remark = remark;
        this.accountType = accountType;
    }

    @Generated(hash = 691197240)
    public AccountData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOriginMoney() {
        return this.originMoney;
    }

    public void setOriginMoney(String originMoney) {
        this.originMoney = originMoney;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    @Override
    public String toString() {
        return "AccountData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", originMoney='" + originMoney + '\'' +
                ", remark='" + remark + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}

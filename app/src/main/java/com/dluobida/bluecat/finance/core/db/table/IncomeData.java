/*
 * project ：BluecatFinance
 * author : dluobida
 * class : IncomeData.java
 * package : com.dluobida.bluecat.finance.core.db.table.IncomeData
 * currentModifyTime : 2020-12-16 21:34:32
 * lastModifyTime : 2020-12-16 21:34:32
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.core.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 收入数据表
 */
@Entity
public class IncomeData {
    @Id(autoincrement = true)
    private Long id;

    private String date;

    private String money;

    private String catagroy;

    private String account;

    private String remark;

    @Generated(hash = 121000241)
    public IncomeData(Long id, String date, String money, String catagroy, String account, String remark) {
        this.id = id;
        this.date = date;
        this.money = money;
        this.catagroy = catagroy;
        this.account = account;
        this.remark = remark;
    }

    @Generated(hash = 1495674592)
    public IncomeData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCatagroy() {
        return catagroy;
    }

    public void setCatagroy(String catagroy) {
        this.catagroy = catagroy;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "IncomeData{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", money='" + money + '\'' +
                ", catagroy='" + catagroy + '\'' +
                ", account='" + account + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

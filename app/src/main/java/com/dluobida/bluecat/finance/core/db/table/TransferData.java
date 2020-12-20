/*
 * project ：BluecatFinance
 * author : dluobida
 * class : TransferData.java
 * package : com.dluobida.bluecat.finance.core.db.table.TransferData
 * currentModifyTime : 2020-12-18 22:44:51
 * lastModifyTime : 2020-12-18 22:44:51
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.core.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TransferData {
    @Id(autoincrement = true)
    private Long id;

    private String date;

    private String money;

    private String accountOut;

    private String accountIn;

    private String remark;

    @Generated(hash = 1148370379)
    public TransferData(Long id, String date, String money, String accountOut,
            String accountIn, String remark) {
        this.id = id;
        this.date = date;
        this.money = money;
        this.accountOut = accountOut;
        this.accountIn = accountIn;
        this.remark = remark;
    }

    @Generated(hash = 1231006818)
    public TransferData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getAccountOut() {
        return this.accountOut;
    }

    public void setAccountOut(String accountOut) {
        this.accountOut = accountOut;
    }

    public String getAccountIn() {
        return this.accountIn;
    }

    public void setAccountIn(String accountIn) {
        this.accountIn = accountIn;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

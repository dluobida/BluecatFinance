/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandData.java
 * package : com.dluobida.junjiefinance.core.greendao.ExpandData
 * currentModifyTime : 2019-11-27 22:50:14
 * lastModifyTime : 2019-11-27 22:50:14
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.core.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 支出数据表
 */
@Entity
public class ExpandData {

    @Id(autoincrement = true)
    private Long id;

    private String date;

    private String money;

    private String catagroy;

    private String account;

    private String remark;

    @Generated(hash = 420482904)
    public ExpandData(Long id, String date, String money, String catagroy, String account, String remark) {
        this.id = id;
        this.date = date;
        this.money = money;
        this.catagroy = catagroy;
        this.account = account;
        this.remark = remark;
    }

    @Generated(hash = 2056351720)
    public ExpandData() {
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ExpandData{" +
                "id=" + id +
                ", date=" + date +
                ", money='" + money + '\'' +
                ", catagroy='" + catagroy + '\'' +
                ", account='" + account + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

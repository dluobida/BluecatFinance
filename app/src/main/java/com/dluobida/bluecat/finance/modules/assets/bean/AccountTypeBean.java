/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountTypeBean.java
 * package : com.dluobida.bluecat.finance.modules.assets.bean.AccountTypeBean
 * currentModifyTime : 2020-02-06 22:00:21
 * lastModifyTime : 2020-02-06 22:00:20
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.bean;

public class AccountTypeBean {
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccountTypeBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

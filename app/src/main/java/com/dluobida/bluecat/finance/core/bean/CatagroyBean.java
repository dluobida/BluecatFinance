/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CatagroyBean.java
 * package : com.dluobida.bluecat.finance.core.bean.CatagroyBean
 * currentModifyTime : 2020-12-16 22:20:57
 * lastModifyTime : 2020-02-10 14:00:00
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.core.bean;

import java.util.List;

public class CatagroyBean {
    private String name;
    private List<String> secondType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSecondType() {
        return secondType;
    }

    public void setSecondType(List<String> secondType) {
        this.secondType = secondType;
    }

    @Override
    public String toString() {
        return "CatagroyBean{" +
                "name='" + name + '\'' +
                ", secondType=" + secondType +
                '}';
    }
}

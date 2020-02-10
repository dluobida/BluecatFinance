/*
 * project ：BluecatFinance
 * author : dluobida
 * class : MathMoneyUtils.java
 * package : com.dluobida.bluecat.finance.utils.MathMoneyUtils
 * currentModifyTime : 2020-02-10 15:32:26
 * lastModifyTime : 2020-02-10 15:32:26
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.utils;

import java.math.BigDecimal;

/**
 * 加减乘除
 */
public class MathMoneyUtils {
    private MathMoneyUtils() {

    }

    /**
     * 提供精确的加法计算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static String add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).toString();
    }

    /**
     * 提供精确的减法计算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static String sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).toString();
    }


}

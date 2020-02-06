/*
 * project ：BluecatFinance
 * author : dluobida
 * class : LogUtils.java
 * package : com.dluobida.bluecat.finance.utils.LogUtils
 * currentModifyTime : 2020-02-06 19:31:09
 * lastModifyTime : 2020-02-06 19:31:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.utils;

import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

public class LogUtils {
    public static void init() {
        XLog.init(LogLevel.ALL);
    }

    public static void v(String msg) {
        XLog.v(msg);
    }

    public static void d(String msg) {
        XLog.d(msg);
    }

    public static void i(String msg) {
        XLog.i(msg);
    }

    public static void w(String msg) {
        XLog.w(msg);
    }

    public static void e(String msg) {
        XLog.e(msg);
    }
}

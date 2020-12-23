/*
 * project ：BluecatFinance
 * author : dluobida
 * class : PickerViewCallback.java
 * package : com.dluobida.bluecat.finance.base.callback.PickerViewCallback
 * currentModifyTime : 2020-12-22 23:37:14
 * lastModifyTime : 2020-12-22 23:37:14
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.base.callback;

public interface PickerViewCallback {
    void onOptionsSelect(String selectName);
    void onTimeSelect(String time);
}

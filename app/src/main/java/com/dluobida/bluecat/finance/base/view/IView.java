/*
 * project ：JunjieFinance
 * author : dluobida
 * class : IView.java
 * package : com.dluobida.junjiefinance.base.view.IView
 * currentModifyTime : 2019-10-31 22:27:43
 * lastModifyTime : 2019-10-31 22:27:43
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.base.view;

public interface IView {
    void showErrorMsg(String errorMsg);

    void showLoading();

    void hideLoading();
}

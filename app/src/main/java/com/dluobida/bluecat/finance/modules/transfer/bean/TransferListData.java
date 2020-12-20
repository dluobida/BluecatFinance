/*
 * project ：BluecatFinance
 * author : dluobida
 * class : TransferListData.java
 * package : com.dluobida.bluecat.finance.modules.transfer.bean.TransferListData
 * currentModifyTime : 2020-12-17 23:09:37
 * lastModifyTime : 2020-12-16 22:37:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.bean;

import com.dluobida.bluecat.finance.core.db.table.TransferData;

import java.util.List;

public class TransferListData {
    private int curPage;
    private List<TransferData> datas;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<TransferData> getDatas() {
        return datas;
    }

    public void setDatas(List<TransferData> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

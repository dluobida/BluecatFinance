/*
 * project ：BluecatFinance
 * author : dluobida
 * class : ExpandListData.java
 * package : com.dluobida.bluecat.finance.modules.expand.bean.ExpandListData
 * currentModifyTime : 2020-02-11 13:22:33
 * lastModifyTime : 2020-02-11 13:22:32
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.bean;

import com.dluobida.bluecat.finance.core.db.table.ExpandData;

import java.util.List;

public class ExpandListData {
    private int curPage;
    private List<ExpandData> datas;
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

    public List<ExpandData> getDatas() {
        return datas;
    }

    public void setDatas(List<ExpandData> datas) {
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

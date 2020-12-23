/*
 * project ：BluecatFinance
 * author : dluobida
 * class : QuickExpandListAdapter.java
 * package : com.dluobida.bluecat.finance.modules.expand.adapter.QuickExpandListAdapter
 * currentModifyTime : 2020-02-11 12:46:19
 * lastModifyTime : 2020-02-11 12:46:18
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.utils.DateUtils;

import java.util.List;

public class QuickExpandListAdapter extends BaseQuickAdapter<ExpandData, BaseViewHolder> {
    public QuickExpandListAdapter(int layoutResId, @Nullable List<ExpandData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ExpandData item) {
        helper.setText(R.id.tv_money,item.getMoney());
        helper.setText(R.id.tv_catagroy,item.getCatagroy());
        helper.setText(R.id.tv_date, DateUtils.timeToDate(item.getDate(),DateUtils.YYYY_MM_DD));
        helper.setText(R.id.tv_account,item.getAccount());
        helper.setText(R.id.tv_remark,item.getRemark());
    }
}

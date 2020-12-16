/*
 * project ：BluecatFinance
 * author : dluobida
 * class : QuickIncomeListAdapter.java
 * package : com.dluobida.bluecat.finance.modules.income.adapter.QuickIncomeListAdapter
 * currentModifyTime : 2020-12-16 22:30:20
 * lastModifyTime : 2020-12-16 22:30:20
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.utils.DateUtils;

import java.util.List;

public class QuickIncomeListAdapter extends BaseQuickAdapter<IncomeData, BaseViewHolder> {
    public QuickIncomeListAdapter(int layoutResId, @Nullable List<IncomeData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IncomeData item) {
        helper.setText(R.id.tv_money,item.getMoney());
        helper.setText(R.id.tv_catagroy,item.getCatagroy());
        helper.setText(R.id.tv_date, DateUtils.timeToDate(item.getDate(),DateUtils.YYYY_MM_DD_HH_MM));
        helper.setText(R.id.tv_account,item.getAccount());
        helper.setText(R.id.tv_remark,item.getRemark());
    }
}

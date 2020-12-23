/*
 * project ：BluecatFinance
 * author : dluobida
 * class : QuickIncomeListAdapter.java
 * package : com.dluobida.bluecat.finance.modules.transfer.adapter.QuickIncomeListAdapter
 * currentModifyTime : 2020-12-17 23:09:37
 * lastModifyTime : 2020-12-16 22:37:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.utils.DateUtils;

import java.util.List;

public class QuickTransferListAdapter extends BaseQuickAdapter<TransferData, BaseViewHolder> {
    public QuickTransferListAdapter(int layoutResId, @Nullable List<TransferData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TransferData item) {
        helper.setText(R.id.tv_money,item.getMoney());
        helper.setText(R.id.tv_account_out,item.getAccountOut());
        helper.setText(R.id.tv_date, DateUtils.timeToDate(item.getDate(),DateUtils.YYYY_MM_DD));
        helper.setText(R.id.tv_account_in,item.getAccountIn());
        helper.setText(R.id.tv_remark,item.getRemark());
    }
}

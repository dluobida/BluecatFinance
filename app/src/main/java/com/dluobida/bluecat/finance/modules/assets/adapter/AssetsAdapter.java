/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AssetsAdapter.java
 * package : com.dluobida.bluecat.finance.modules.assets.adapter.AssetsAdapter
 * currentModifyTime : 2020-02-08 13:46:29
 * lastModifyTime : 2020-02-08 13:46:29
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.core.db.table.AccountData;

import java.util.List;

public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.ViewHolder> {

    private List<AccountData> accountDataList;

    public AssetsAdapter(List<AccountData> accountDataList) {
        this.accountDataList = accountDataList;
    }

    @NonNull
    @Override
    public AssetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_assets_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AccountData accountData = accountDataList.get(i);
        viewHolder.tvMoney.setText(accountData.getMoney());
        viewHolder.tvName.setText(accountData.getName());

    }

    @Override
    public int getItemCount() {
        return accountDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvMoney;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_account_type);
            tvMoney = itemView.findViewById(R.id.tv_account_money);
        }

    }
}

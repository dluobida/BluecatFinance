/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandListAdapter.java
 * package : com.dluobida.junjiefinance.modules.expand.adapter.ExpandListAdapter
 * currentModifyTime : 2019-12-08 23:09:18
 * lastModifyTime : 2019-12-08 23:09:17
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.core.greendao.ExpandData;

import java.util.List;

public class ExpandListAdapter extends RecyclerView.Adapter<ExpandListAdapter.ViewHolder> {
    private List<ExpandData> mExpandDataList;

    public ExpandListAdapter(List<ExpandData> expandDataList){
        mExpandDataList = expandDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_expand_list,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExpandData expandData = mExpandDataList.get(i);
        viewHolder.tvName.setText(expandData.toString());

    }

    @Override
    public int getItemCount() {
        return mExpandDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }


}

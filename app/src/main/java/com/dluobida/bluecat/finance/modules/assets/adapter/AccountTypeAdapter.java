/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountTypeAdapter.java
 * package : com.dluobida.bluecat.finance.modules.assets.adapter.AccountTypeAdapter
 * currentModifyTime : 2020-02-06 23:06:49
 * lastModifyTime : 2020-02-06 23:06:48
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.modules.assets.bean.AccountTypeBean;

import java.util.List;

public class AccountTypeAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<AccountTypeBean> datas;

    public AccountTypeAdapter(Context context, List<AccountTypeBean> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_account_type,null);
            holder.tvName = convertView.findViewById(R.id.tv_account_type);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(datas.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView tvName;
    }
}

/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateAccountActivity.java
 * package : com.dluobida.bluecat.finance.modules.assets.ui.activity.CreateAccountActivity
 * currentModifyTime : 2020-02-06 15:05:04
 * lastModifyTime : 2020-02-06 15:05:04
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.activity.BaseActivity;
import com.dluobida.bluecat.finance.modules.assets.adapter.AccountTypeAdapter;
import com.dluobida.bluecat.finance.modules.assets.bean.AccountTypeBean;
import com.dluobida.bluecat.finance.modules.assets.contract.CreateAccountContract;
import com.dluobida.bluecat.finance.modules.assets.presenter.CreateAccountPresenter;
import com.dluobida.bluecat.finance.utils.AssetsUtils;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

public class CreateAccountActivity extends BaseActivity<CreateAccountPresenter> implements CreateAccountContract.View {

    private List<AccountTypeBean> datas;
    private AccountTypeAdapter adapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.lv_account_type_list)
    ListView lvAccountTypeList;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_account;
    }

    @Override
    protected void initView() {
        datas = getAccountTypes();
        adapter = new AccountTypeAdapter(this,datas);
        lvAccountTypeList.setAdapter(adapter);

    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("账户类型");
        }

    }

    @OnItemClick({R.id.lv_account_type_list})
    public void OnItemClick(int position){
        Intent intent = new Intent(this,AccountDetailActivity.class);
        intent.putExtra("accountType",datas.get(position).getType());
        startActivity(intent);
    }


    private List<AccountTypeBean> getAccountTypes(){
        String accountType = AssetsUtils.getJsonFromAsset(this,"accountType.json");
        Gson gson = new Gson();
        List<AccountTypeBean> datas = gson.fromJson(accountType, new TypeToken<List<AccountTypeBean>>(){}.getType());
        LogUtils.i("accountType=" + datas.toString());
        return datas;
    }

}

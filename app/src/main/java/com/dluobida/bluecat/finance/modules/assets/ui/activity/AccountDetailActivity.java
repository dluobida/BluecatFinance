/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AccountDetailActivity.java
 * package : com.dluobida.bluecat.finance.modules.assets.ui.activity.AccountDetailActivity
 * currentModifyTime : 2020-02-08 11:47:37
 * lastModifyTime : 2020-02-08 11:47:36
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.assets.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.activity.BaseActivity;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.modules.assets.contract.AccountDetailContract;
import com.dluobida.bluecat.finance.modules.assets.presenter.AccountDetailPresenter;
import com.dluobida.bluecat.finance.modules.main.ui.activity.MainActivity;
import com.dluobida.bluecat.finance.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountDetailActivity extends BaseActivity<AccountDetailPresenter> implements AccountDetailContract.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.et_account_name)
    EditText etAccountName;
    @BindView(R.id.et_account_money)
    EditText etAccountMoney;
    @BindView(R.id.et_account_remark)
    EditText etAccountRemark;

    private String accountType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_detail;
    }

    @Override
    protected void initView() {
        accountType = getIntent().getStringExtra("accountType");
        LogUtils.i("accountType=" + accountType);


    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("创建账户");
        }

    }

    @OnClick(R.id.btn_account_create)
    public void onClick(){
        String name = etAccountName.getText().toString().trim();
        String money = etAccountMoney.getText().toString().trim();
        String remark = etAccountRemark.getText().toString().trim();
        AccountData accountData = new AccountData();
        accountData.setAccountType(accountType);
        accountData.setName(name);
        accountData.setMoney(money);
        accountData.setOriginMoney(money);
        accountData.setRemark(remark);
        mPresenter.saveAccountData(accountData);
        LogUtils.i("accountDataList=" + mPresenter.queryAllAccountData().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

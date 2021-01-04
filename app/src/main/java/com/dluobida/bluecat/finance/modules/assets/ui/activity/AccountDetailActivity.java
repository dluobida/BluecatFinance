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
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.activity.BaseActivity;
import com.dluobida.bluecat.finance.base.callback.PickerViewCallback;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.modules.assets.bean.AccountTypeBean;
import com.dluobida.bluecat.finance.modules.assets.contract.AccountDetailContract;
import com.dluobida.bluecat.finance.modules.assets.presenter.AccountDetailPresenter;
import com.dluobida.bluecat.finance.modules.main.ui.activity.MainActivity;
import com.dluobida.bluecat.finance.utils.AssetsUtils;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.PickerViewUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.tv_account_type)
    TextView tvAccountType;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_detail;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("创建账户");
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());

    }

    @OnClick({R.id.btn_account_create,R.id.tv_account_type})
    public void OnViewClicked(View view){
        switch (view.getId()) {
            case R.id.btn_account_create:
                String name = etAccountName.getText().toString().trim();
                String money = etAccountMoney.getText().toString().trim();
                String remark = etAccountRemark.getText().toString().trim();
                String accountType = tvAccountType.getText().toString().trim();
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
                break;
            case R.id.tv_account_type:
                PickerViewUtils.showChooseList(AccountDetailActivity.this, "账号类型", getAccountTypes(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvAccountType.setText(chooseName);
                    }
                });
                break;
        }

    }

    private List<String> getAccountTypes(){
        List<String> types = new ArrayList<>();
        String accountType = AssetsUtils.getJsonFromAsset(this,"accountType.json");
        Gson gson = new Gson();
        List<AccountTypeBean> datas = gson.fromJson(accountType, new TypeToken<List<AccountTypeBean>>(){}.getType());
        for(AccountTypeBean bean : datas){
            types.add(bean.getName());
        }
        return types;
    }
}

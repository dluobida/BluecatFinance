/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateIncomeActivity.java
 * package : com.dluobida.bluecat.finance.modules.income.ui.activity.CreateIncomeActivity
 * currentModifyTime : 2020-12-16 21:24:47
 * lastModifyTime : 2020-12-16 21:24:46
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.income.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.dluobida.bluecat.finance.R;
import com.dluobida.bluecat.finance.base.activity.BaseActivity;
import com.dluobida.bluecat.finance.base.callback.PickerViewCallback;
import com.dluobida.bluecat.finance.core.bean.CatagroyBean;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.contract.CreateIncomeContract;
import com.dluobida.bluecat.finance.modules.income.presenter.CreateIncomePresenter;
import com.dluobida.bluecat.finance.utils.AssetsUtils;
import com.dluobida.bluecat.finance.utils.DateUtils;
import com.dluobida.bluecat.finance.utils.LogUtils;
import com.dluobida.bluecat.finance.utils.PickerViewUtils;
import com.dluobida.bluecat.finance.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateIncomeActivity extends BaseActivity<CreateIncomePresenter> implements CreateIncomeContract.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.btn_income_save)
    Button btnSave;
    @BindView(R.id.btn_income_delete)
    Button btnDelete;
    @BindView(R.id.et_income_money)
    EditText etIncomeMoney;
    @BindView(R.id.tv_income_type)
    TextView tvIncomeType;
    @BindView(R.id.tv_income_account)
    TextView tvIncomeAccount;
    @BindView(R.id.tv_income_time)
    TextView tvIncomeTime;
    @BindView(R.id.et_income_remark)
    EditText etIncomeRemark;

    private String type;
    private Long id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_income;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        if("edit".equals(type)){
            String data = intent.getStringExtra("data");
            IncomeData incomeData = new Gson().fromJson(data,IncomeData.class);
            etIncomeMoney.setText(incomeData.getMoney());
            tvIncomeType.setText(incomeData.getCatagroy());
            tvIncomeAccount.setText(incomeData.getAccount());
            etIncomeRemark.setText(incomeData.getRemark());
            tvIncomeTime.setText(incomeData.getDate());
            id = incomeData.getId();
        }

    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("创建收入");
        }

    }

    @OnClick({R.id.btn_income_save,R.id.btn_income_delete, R.id.tv_income_type, R.id.tv_income_time,R.id.tv_income_account})
    public void OnViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_income_save:
                ToastUtils.showToast(CreateIncomeActivity.this, "点击了保存");
                IncomeData incomeData = getIncomeData();
                mPresenter.saveIncomeData(incomeData);
                finish();
                break;
            case R.id.btn_income_delete:
                ToastUtils.showToast(CreateIncomeActivity.this, "点击了删除");
                mPresenter.deleteIncomeData(getIncomeData().getId());
                finish();
                break;
            case R.id.tv_income_type:
                PickerViewUtils.showChooseList(CreateIncomeActivity.this, "收入类型", getIncomeType(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvIncomeType.setText(chooseName);
                    }
                });

                break;
            case R.id.tv_income_account:
                PickerViewUtils.showChooseList(CreateIncomeActivity.this, "账户选择", getAccountList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvIncomeAccount.setText(chooseName);
                    }
                });
                break;
            case R.id.tv_income_time:
                Log.i("dengjj", "click income time");
                PickerViewUtils.showTimeChoose(CreateIncomeActivity.this, new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvIncomeTime.setText(chooseName);
                    }
                });
                break;
        }

    }

    private List<String> getIncomeType(){
        String incomeType = AssetsUtils.getJsonFromAsset(this,"incomeType.json");
        Gson gson = new Gson();
        List<String> datas = gson.fromJson(incomeType, new TypeToken<List<String>>(){}.getType());
        return datas;
    }

    private List<String> getAccountList(){
        List<String> accountList = new ArrayList<>();
        List<AccountData> datas = mPresenter.queryAllAccountData();
        for (AccountData item : datas) {
            accountList.add(item.getName());
        }
        return accountList;
    }

    private IncomeData getIncomeData() {
        IncomeData incomeData = new IncomeData();
        String incomeMoney = etIncomeMoney.getText().toString().trim();
        String catagroy = tvIncomeType.getText().toString();
        String account = tvIncomeAccount.getText().toString();
        String remark = etIncomeRemark.getText().toString().trim();
        String date = tvIncomeTime.getText().toString();
        incomeData.setMoney(incomeMoney);
        incomeData.setCatagroy(catagroy);
        incomeData.setAccount(account);
        incomeData.setDate(date);
        incomeData.setRemark(remark);
        incomeData.setId(id);
        return incomeData;
    }
}

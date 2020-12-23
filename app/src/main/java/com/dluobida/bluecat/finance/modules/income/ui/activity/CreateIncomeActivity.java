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
import com.dluobida.bluecat.finance.core.bean.CatagroyBean;
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.modules.income.contract.CreateIncomeContract;
import com.dluobida.bluecat.finance.modules.income.presenter.CreateIncomePresenter;
import com.dluobida.bluecat.finance.utils.AssetsUtils;
import com.dluobida.bluecat.finance.utils.DateUtils;
import com.dluobida.bluecat.finance.utils.LogUtils;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_income;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.btn_income_save, R.id.tv_income_type, R.id.tv_income_time,R.id.tv_income_account})
    public void OnViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_income_save:
                ToastUtils.showToast(CreateIncomeActivity.this, "点击了保存");
                IncomeData incomeData = getIncomeData();
                mPresenter.saveIncomeData(incomeData);
                List<IncomeData> datas = mPresenter.queryAllIncomeData();
                Log.i("dengjj", "incomeData=" + datas.toString());
                finish();
                break;
            case R.id.tv_income_type:
                chooseIncomeType();
                break;
            case R.id.tv_income_account:
                chooseIncomeaccount();
                break;
            case R.id.tv_income_time:
                Log.i("dengjj", "click income time");
                chooseIncomeTime();
                break;
        }

    }

    private void chooseIncomeaccount() {
        List<String> options1Items = getAccountList();
        OptionsPickerView pvOptions = new OptionsPickerBuilder(CreateIncomeActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1);
                tvIncomeAccount.setText(tx);
            }
        })
                .setTitleText("账户选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setOutSideColor(0x00000000) //设置外部遮罩颜色
                .build();
        pvOptions.setPicker(options1Items);
        pvOptions.show();

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
        //将date转换为时间戳
        String time = DateUtils.dateToTime(date,DateUtils.YYYY_MM_DD);
        incomeData.setMoney(incomeMoney);
        incomeData.setCatagroy(catagroy);
        incomeData.setAccount(account);
        incomeData.setDate(time);
        incomeData.setRemark(remark);
        return incomeData;
    }

    private void chooseIncomeType() {
        List<CatagroyBean> catagroys = getCatagroy();
        List<String> options1Items = new ArrayList<>();
        List<List<String>> options2Items = new ArrayList<>();
        for(int i=0;i<catagroys.size();i++){
            options1Items.add(catagroys.get(i).getName());
            options2Items.add(catagroys.get(i).getSecondType());
        }
        OptionsPickerView pvOptions = new OptionsPickerBuilder(CreateIncomeActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1) + " > " + options2Items.get(options1).get(options2);
                tvIncomeType.setText(tx);
            }
        })
                .setTitleText("分类选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setOutSideColor(0x00000000) //设置外部遮罩颜色
                .build();
        pvOptions.setPicker(options1Items, options2Items);
        pvOptions.show();
    }

    private void chooseIncomeTime() {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(CreateIncomeActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                tvIncomeTime.setText(DateUtils.timeToDate(date,DateUtils.YYYY_MM_DD));
            }
        }).setType(new boolean[]{true, true, true, true, true, false}).build();
        pvTime.show();
    }

    private List<CatagroyBean> getCatagroy(){
        String catagroy = AssetsUtils.getJsonFromAsset(this,"catagroy.json");
        Gson gson = new Gson();
        List<CatagroyBean> datas = gson.fromJson(catagroy, new TypeToken<List<CatagroyBean>>(){}.getType());
        LogUtils.i("catagroy=" + datas.toString());
        return datas;
    }
}

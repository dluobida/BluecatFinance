/*
 * project ：BluecatFinance
 * author : dluobida
 * class : CreateTransferActivity.java
 * package : com.dluobida.bluecat.finance.modules.transfer.ui.activity.CreateTransferActivity
 * currentModifyTime : 2020-12-17 23:05:21
 * lastModifyTime : 2020-12-16 22:39:50
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.modules.transfer.ui.activity;

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
import com.dluobida.bluecat.finance.core.db.table.TransferData;
import com.dluobida.bluecat.finance.modules.transfer.contract.CreateTransferContract;
import com.dluobida.bluecat.finance.modules.transfer.presenter.CreateTransferPresenter;
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

public class CreateTransferActivity extends BaseActivity<CreateTransferPresenter> implements CreateTransferContract.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.btn_transfer_save)
    Button btnSave;
    @BindView(R.id.et_transfer_money)
    EditText etTransferMoney;
    @BindView(R.id.tv_account_in)
    TextView tvAccountIn;
    @BindView(R.id.tv_account_out)
    TextView tvAccountOut;
    @BindView(R.id.tv_transfer_time)
    TextView tvTransferTime;
    @BindView(R.id.et_transfer_remark)
    EditText etTransferRemark;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_transfer;
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
            mTitle.setText("创建转账");
        }

    }

    @OnClick({R.id.btn_transfer_save, R.id.tv_account_in, R.id.tv_transfer_time,R.id.tv_account_out})
    public void OnViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_transfer_save:
                ToastUtils.showToast(CreateTransferActivity.this, "点击了保存");
                TransferData transferData = getTransferData();
                mPresenter.saveTransferData(transferData);
                List<TransferData> datas = mPresenter.queryAllTransferData();
                Log.i("dengjj", "transferData=" + datas.toString());
                finish();
                break;
            case R.id.tv_account_in:
                PickerViewUtils.showChooseList(CreateTransferActivity.this, "账户选择", getAccountList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvAccountIn.setText(chooseName);
                    }
                });
                break;
            case R.id.tv_account_out:
                PickerViewUtils.showChooseList(CreateTransferActivity.this, "账户选择", getAccountList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvAccountOut.setText(chooseName);
                    }
                });

                break;
            case R.id.tv_transfer_time:
                Log.i("dengjj", "click transfer time");
                PickerViewUtils.showTimeChoose(CreateTransferActivity.this, new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvTransferTime.setText(chooseName);
                    }
                });

                break;
        }

    }


    private List<String> getAccountList(){
        List<String> accountList = new ArrayList<>();
        List<AccountData> datas = mPresenter.queryAllAccountData();
        for (AccountData item : datas) {
            accountList.add(item.getName());
        }
        return accountList;
    }

    private TransferData getTransferData() {
        TransferData transferData = new TransferData();
        String transferMoney = etTransferMoney.getText().toString().trim();
        String accountIn = tvAccountIn.getText().toString();
        String accountOut = tvAccountOut.getText().toString();
        String remark = etTransferRemark.getText().toString().trim();
        String date = tvTransferTime.getText().toString();
        //将date转换为时间戳
        String time = DateUtils.dateToTime(date,DateUtils.YYYY_MM_DD);
        transferData.setMoney(transferMoney);
        transferData.setAccountIn(accountIn);
        transferData.setAccountOut(accountOut);
        transferData.setDate(time);
        transferData.setRemark(remark);
        return transferData;
    }
}

/*
 * project ：JunjieFinance
 * author : dluobida
 * class : CreateExpandActivity.java
 * package : com.dluobida.junjiefinance.modules.expand.ui.activity.CreateExpandActivity
 * currentModifyTime : 2019-12-08 16:08:46
 * lastModifyTime : 2019-12-08 16:08:45
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.bluecat.finance.modules.expand.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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
import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.core.bean.CatagroyBean;
import com.dluobida.bluecat.finance.modules.expand.contract.CreateExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.CreateExpandPresenter;
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

public class CreateExpandActivity extends BaseActivity<CreateExpandPresenter> implements CreateExpandContract.View, TextView.OnEditorActionListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.btn_expand_save)
    Button btnSave;
    @BindView(R.id.btn_expand_delete)
    Button btnDelete;
    @BindView(R.id.et_expand_money)
    EditText etExpandMoney;
    @BindView(R.id.tv_expand_type)
    TextView tvExpandType;
    @BindView(R.id.tv_expand_account)
    TextView tvExpandAccount;
    @BindView(R.id.tv_expand_time)
    TextView tvExpandTime;
    @BindView(R.id.et_expand_remark)
    EditText etExpandRemark;

    private String type;
    private Long id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_expand;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        if("edit".equals(type)){
            String data = intent.getStringExtra("data");
            ExpandData expandData = new Gson().fromJson(data,ExpandData.class);
            etExpandMoney.setText(expandData.getMoney());
            tvExpandType.setText(expandData.getCatagroy());
            tvExpandAccount.setText(expandData.getAccount());
            etExpandRemark.setText(expandData.getRemark());
            tvExpandTime.setText(expandData.getDate());
            id = expandData.getId();
        }else {
            //TODO 初始化默认值
            tvExpandType.setText(getExpandList().size() > 0 ?getExpandList().get(0):"");
            tvExpandAccount.setText(getAccountList().size() > 0 ?getAccountList().get(0):"");
            tvExpandTime.setText(DateUtils.getNowDate());

        }
//        etExpandMoney.setOnEditorActionListener(this);

    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            mTitle.setText("创建支出");
        }
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @OnClick({R.id.btn_expand_save, R.id.btn_expand_delete,R.id.tv_expand_type, R.id.tv_expand_time,R.id.tv_expand_account})
    public void OnViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_expand_save:
                ToastUtils.showToast(CreateExpandActivity.this, "点击了保存");
                ExpandData expandData = getExpandData();
                mPresenter.saveExpandData(expandData);
                finish();
                break;
            case R.id.btn_expand_delete:
                ToastUtils.showToast(CreateExpandActivity.this, "点击了删除");
                mPresenter.deleteExpandDataById(getExpandData().getId());
                finish();
                break;
            case R.id.tv_expand_type:
                PickerViewUtils.showChooseList(CreateExpandActivity.this, "支出类型", getExpandList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvExpandType.setText(chooseName);
                    }
                });
                break;
            case R.id.tv_expand_account:
                PickerViewUtils.showChooseList(CreateExpandActivity.this, "账户选择", getAccountList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvExpandAccount.setText(chooseName);
                    }
                });
                break;
            case R.id.tv_expand_time:
                Log.i("dengjj", "click expand time");
                PickerViewUtils.showTimeChoose(CreateExpandActivity.this, new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvExpandTime.setText(chooseName);
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

    private List<String> getExpandList(){
        String expandType = AssetsUtils.getJsonFromAsset(this,"expandType.json");
        Gson gson = new Gson();
        List<String> datas = gson.fromJson(expandType, new TypeToken<List<String>>(){}.getType());
        return datas;
    }

    private ExpandData getExpandData() {
        ExpandData expandData = new ExpandData();
        String expandMoney = etExpandMoney.getText().toString().trim();
        String catagroy = tvExpandType.getText().toString();
        String account = tvExpandAccount.getText().toString();
        String remark = etExpandRemark.getText().toString().trim();
        String date = tvExpandTime.getText().toString();
        expandData.setMoney(expandMoney);
        expandData.setCatagroy(catagroy);
        expandData.setAccount(account);
        expandData.setDate(date);
        expandData.setRemark(remark);
        expandData.setId(id);
        return expandData;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId){
            case EditorInfo.IME_ACTION_NEXT:
                PickerViewUtils.showChooseList(CreateExpandActivity.this, "支出类型", getExpandList(), new PickerViewCallback() {
                    @Override
                    public void onChoosed(String chooseName) {
                        tvExpandType.setText(chooseName);
                    }
                });
                break;
        }
        return true;
    }
}

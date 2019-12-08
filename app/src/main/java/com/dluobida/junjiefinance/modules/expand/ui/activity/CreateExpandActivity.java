/*
 * project ：JunjieFinance
 * author : dluobida
 * class : CreateExpandActivity.java
 * package : com.dluobida.junjiefinance.modules.expand.ui.activity.CreateExpandActivity
 * currentModifyTime : 2019-12-08 16:08:46
 * lastModifyTime : 2019-12-08 16:08:45
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.activity.BaseActivity;
import com.dluobida.junjiefinance.core.greendao.ExpandData;
import com.dluobida.junjiefinance.modules.expand.contract.CreateExpandContract;
import com.dluobida.junjiefinance.modules.expand.presenter.CreateExpandPresenter;
import com.dluobida.junjiefinance.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateExpandActivity extends BaseActivity<CreateExpandPresenter> implements CreateExpandContract.View {
    @BindView(R.id.btn_expand_save)
    Button btnSave;
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
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_expand;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initToolbar() {

    }

    @OnClick({R.id.btn_expand_save})
    public void OnViewClicked(View view){
        switch (view.getId()){
            case R.id.btn_expand_save:
                ToastUtils.showToast(CreateExpandActivity.this,"点击了保存");
                ExpandData expandData = getExpandData();
                mPresenter.saveExpandData(expandData);
                List<ExpandData> datas = mPresenter.queryAllExpandData();
                Log.i("dengjj","expandData="+datas.toString());
                finish();
                break;
        }

    }

    private ExpandData getExpandData(){
        ExpandData expandData = new ExpandData();
        String expandMoney = etExpandMoney.getText().toString().trim();
        String catagroy = tvExpandType.getText().toString();
        String account = tvExpandAccount.getText().toString();
        String date = tvExpandTime.getText().toString();
        String remark = etExpandRemark.getText().toString().trim();
        expandData.setMoney(expandMoney);
        expandData.setCatagroy(catagroy);
        expandData.setAccount(account);
        expandData.setDate(date);
        expandData.setRemark(remark);
        return expandData;
    }
}

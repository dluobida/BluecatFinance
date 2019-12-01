/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ExpandFragment.java
 * package : com.dluobida.junjiefinance.modules.expand.ui.fragment.ExpandFragment
 * currentModifyTime : 2019-11-16 23:10:04
 * lastModifyTime : 2019-11-16 23:10:03
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.modules.expand.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dluobida.junjiefinance.R;
import com.dluobida.junjiefinance.base.fragment.BaseFragment;
import com.dluobida.junjiefinance.core.greendao.ExpandData;
import com.dluobida.junjiefinance.modules.expand.contract.ExpandContract;
import com.dluobida.junjiefinance.modules.expand.presenter.ExpandPresenter;
import com.dluobida.junjiefinance.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
//TODO 支出页面单独一个activity，此fragment展示列表
public class ExpandFragment extends BaseFragment<ExpandPresenter> implements ExpandContract.View{

    private static final String TAG = ExpandFragment.class.getSimpleName();
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


    public static ExpandFragment getInstance(){
        ExpandFragment instance = new ExpandFragment();
        return instance;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_expand;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick({R.id.btn_expand_save})
    public void OnViewClicked(View view){
        switch (view.getId()){
            case R.id.btn_expand_save:
                ToastUtils.showToast(_mActivity,"点击了保存");
                ExpandData expandData = getExpandData();
                mPresenter.saveExpandData(expandData);
                List<ExpandData> datas = mPresenter.queryAllExpandData();
                Log.i("dengjj","expandData="+datas.toString());
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

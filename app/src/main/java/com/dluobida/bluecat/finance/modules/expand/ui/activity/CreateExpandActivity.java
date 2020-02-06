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

import android.graphics.Color;
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
import com.dluobida.bluecat.finance.core.greendao.ExpandData;
import com.dluobida.bluecat.finance.modules.expand.contract.CreateExpandContract;
import com.dluobida.bluecat.finance.modules.expand.presenter.CreateExpandPresenter;
import com.dluobida.bluecat.finance.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @OnClick({R.id.btn_expand_save, R.id.tv_expand_type, R.id.tv_expand_time,R.id.tv_expand_account})
    public void OnViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_expand_save:
                ToastUtils.showToast(CreateExpandActivity.this, "点击了保存");
                ExpandData expandData = getExpandData();
                mPresenter.saveExpandData(expandData);
                List<ExpandData> datas = mPresenter.queryAllExpandData();
                Log.i("dengjj", "expandData=" + datas.toString());
                finish();
                break;
            case R.id.tv_expand_type:
                chooseExpandType();
                break;
            case R.id.tv_expand_account:
                chooseExpandaccount();
                break;
            case R.id.tv_expand_time:
                Log.i("dengjj", "click expand time");
                chooseExpandTime();
                break;
        }

    }

    private void chooseExpandaccount() {
        List<String> options1Items = new ArrayList<>();
        options1Items.add("支付宝");
        options1Items.add("京东支付");
        OptionsPickerView pvOptions = new OptionsPickerBuilder(CreateExpandActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1);
                tvExpandAccount.setText(tx);
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

    private ExpandData getExpandData() {
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

    private void chooseExpandType() {
        List<String> options1Items = new ArrayList<>();
        options1Items.add("食品酒水");
        options1Items.add("居家物业");
        List<List<String>> options2Items = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("早午晚餐");
        item1.add("烟酒茶");
        options2Items.add(item1);
        List<String> item2 = new ArrayList<>();
        item2.add("早午晚餐2");
        item2.add("烟酒茶2");
        options2Items.add(item2);

        OptionsPickerView pvOptions = new OptionsPickerBuilder(CreateExpandActivity.this, new OnOptionsSelectListener() {
            @Override 
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1) + " > " + options2Items.get(options1).get(options2);
                tvExpandType.setText(tx);
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

    private void chooseExpandTime() {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(CreateExpandActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                tvExpandTime.setText(getTime(date));
            }
        }).setType(new boolean[]{true, true, true, true, true, false}).build();
        pvTime.show();
    }

    private String getTime(Date date) {
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return format.format(date);
    }
}

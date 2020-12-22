/*
 * project ：BluecatFinance
 * author : dluobida
 * class : PickerViewUtils.java
 * package : com.dluobida.bluecat.finance.utils.PickerViewUtils
 * currentModifyTime : 2020-12-22 23:29:10
 * lastModifyTime : 2020-12-22 23:29:09
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.dluobida.bluecat.finance.base.callback.PickerViewCallback;
import com.dluobida.bluecat.finance.modules.expand.ui.activity.CreateExpandActivity;

import java.util.List;

public class PickerViewUtils {
    public static void showChooseList(Context context, String title, List<String> options1Items, PickerViewCallback callback){
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1);
                callback.onOptionsSelect(tx);
            }
        })
                .setTitleText(title)
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
}

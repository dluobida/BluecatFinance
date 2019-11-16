/*
 * project ：JunjieFinance
 * author : dluobida
 * class : ToastUtils.java
 * package : com.dluobida.junjiefinance.utils.ToastUtils
 * currentModifyTime : 2019-11-16 22:14:11
 * lastModifyTime : 2019-11-16 22:14:11
 * Copyright (c) 2019 dluobida .
 */

package com.dluobida.junjiefinance.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast mToast;

    public static void showToast(Context mContext,String text,int duration){

        if(mToast == null){
            mToast = Toast.makeText(mContext.getApplicationContext(),text,duration);
        }else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(Context mContext, int resId,int duration){
        showToast(mContext,mContext.getResources().getString(resId),duration);
    }

    public static void showToast(Context mContext,String text){
        showToast(mContext,text,Toast.LENGTH_SHORT);
    }
}

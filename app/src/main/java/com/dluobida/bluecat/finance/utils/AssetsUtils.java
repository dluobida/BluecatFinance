/*
 * project ：BluecatFinance
 * author : dluobida
 * class : AssetsUtils.java
 * package : com.dluobida.bluecat.finance.utils.AssetsUtils
 * currentModifyTime : 2020-02-06 19:07:10
 * lastModifyTime : 2020-02-06 19:07:10
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssetsUtils {
    public static String getJsonFromAsset(Context context,String fileName){
        String result = "";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

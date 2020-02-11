/*
 * project ：BluecatFinance
 * author : dluobida
 * class : DateUtils.java
 * package : com.dluobida.bluecat.finance.utils.DateUtils
 * currentModifyTime : 2020-02-11 08:40:41
 * lastModifyTime : 2020-02-11 08:40:41
 * Copyright (c) 2020 dluobida .
 */

package com.dluobida.bluecat.finance.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH:mm";
    /**
     * 标准日期格式转换为时间戳
     * @param dateStr
     * @param pattern
     * @return
     */
    public static String dateToTime(String dateStr,String pattern){
        String timeStr;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(dateStr);
            long time = date.getTime();
            return String.valueOf(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 时间戳转换为标准日期
     * @param date
     * @param pattern
     * @return
     */
    public static String timeToDate(Date date,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);

    }

    /**
     * 时间戳转换为标准日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static String timeToDate(String dateStr,String pattern){
        long lt = new Long(dateStr);
        Date date = new Date(lt);
        return timeToDate(date,pattern);
    }
}

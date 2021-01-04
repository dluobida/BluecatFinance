package com.dluobida.bluecat.finance.utils;

import android.content.Context;
import android.widget.Toast;

import com.dluobida.bluecat.finance.core.db.table.AccountData;
import com.dluobida.bluecat.finance.core.db.table.ExpandData;
import com.dluobida.bluecat.finance.core.db.table.IncomeData;
import com.dluobida.bluecat.finance.core.db.table.TransferData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author dmrfcoder
 * @date 2019/2/14
 */

public class ExcelUtil {

    private static WritableFont arial14font = null;

    private static WritableCellFormat arial14format = null;
    private static WritableFont arial10font = null;
    private static WritableCellFormat arial10format = null;
    private static WritableFont arial12font = null;
    private static WritableCellFormat arial12format = null;
    private final static String UTF8_ENCODING = "UTF-8";


    /**
     * 单元格的格式设置 字体大小 颜色 对齐方式、背景颜色等...
     */
    private static void format() {
        try {
            arial14font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial14font.setColour(jxl.format.Colour.LIGHT_BLUE);
            arial14format = new WritableCellFormat(arial14font);
            arial14format.setAlignment(jxl.format.Alignment.CENTRE);
            arial14format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);

            arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            arial10format = new WritableCellFormat(arial10font);
            arial10format.setAlignment(jxl.format.Alignment.CENTRE);
            arial10format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            arial10format.setBackground(Colour.GRAY_25);

            arial12font = new WritableFont(WritableFont.ARIAL, 10);
            arial12format = new WritableCellFormat(arial12font);
            //对齐格式
            arial10format.setAlignment(jxl.format.Alignment.CENTRE);
            //设置边框
            arial12format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

        } catch (WriteException e) {
            e.printStackTrace();
        }
    }


    /**
     * 初始化Excel表格
     *
     * @param filePath  存放excel文件的路径（path/demo.xls）
     */
    public static void initExcel(String filePath, String[] sheetNames, List<String[]> colNames) {
        format();
        WritableWorkbook workbook = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            workbook = Workbook.createWorkbook(file);
            for(int sheetNum = 0; sheetNum<sheetNames.length;sheetNum++){


            //设置表格的名字
            WritableSheet sheet = workbook.createSheet(sheetNames[sheetNum], sheetNum);
            //创建标题栏
            sheet.addCell((WritableCell) new Label(0, 0, filePath, arial14format));
            for (int col = 0; col < colNames.get(sheetNum).length; col++) {
                sheet.addCell(new Label(col, 0, colNames.get(sheetNum)[col], arial10format));
            }
            //设置行高
            sheet.setRowView(0, 340);
            }
            workbook.write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将制定类型的List写入Excel中
     *
     * @param objList  待写入的list
     * @param fileName
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> void writeObjListToExcel(List<T> objList, String fileName, int sheetNum) {
        if (objList != null && objList.size() > 0) {
            WritableWorkbook writebook = null;
            InputStream in = null;
            try {
                WorkbookSettings setEncode = new WorkbookSettings();
                setEncode.setEncoding(UTF8_ENCODING);

                in = new FileInputStream(new File(fileName));
                Workbook workbook = Workbook.getWorkbook(in);
                writebook = Workbook.createWorkbook(new File(fileName), workbook);
                WritableSheet sheet = writebook.getSheet(sheetNum);

                for (int j = 0; j < objList.size(); j++) {
//                    DemoBean demoBean = (DemoBean) objList.get(j);
//                    List<String> list = new ArrayList<>();
//                    list.add(demoBean.getName());
//                    list.add(String.valueOf(demoBean.getAge()));
//                    list.add(String.valueOf(demoBean.isBoy()));
                    List<String> list = new ArrayList<>();
                    beanToList(objList.get(j),list);

                    for (int i = 0; i < list.size(); i++) {
                        sheet.addCell(new Label(i, j + 1, list.get(i), arial12format));
                        if (list.get(i).length() <= 4) {
                            //设置列宽
                            sheet.setColumnView(i, list.get(i).length() + 8);
                        } else {
                            //设置列宽
                            sheet.setColumnView(i, list.get(i).length() + 5);
                        }
                    }
                    //设置行高
                    sheet.setRowView(j + 1, 350);
                }


                writebook.write();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writebook != null) {
                    try {
                        writebook.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    private static <T> List<String> beanToList(T bean,List<String> list){
        if(bean instanceof ExpandData){
            ExpandData expandData =  (ExpandData)bean;
            list.add(String.valueOf(expandData.getId()));
            list.add(expandData.getDate());
            list.add(expandData.getMoney());
            list.add(expandData.getCatagroy());
            list.add(expandData.getAccount());
            list.add(expandData.getRemark());
        }else if(bean instanceof IncomeData){
            IncomeData incomeData =  (IncomeData)bean;
            list.add(String.valueOf(incomeData.getId()));
            list.add(incomeData.getDate());
            list.add(incomeData.getMoney());
            list.add(incomeData.getCatagroy());
            list.add(incomeData.getAccount());
            list.add(incomeData.getRemark());
        }else if(bean instanceof TransferData){
            TransferData transferData = (TransferData) bean;
            list.add(String.valueOf(transferData.getId()));
            list.add(transferData.getDate());
            list.add(transferData.getMoney());
            list.add(transferData.getAccountOut());
            list.add(transferData.getAccountIn());
            list.add(transferData.getRemark());
        }else if(bean instanceof AccountData){
            AccountData accountData = (AccountData) bean;
            list.add(String.valueOf(accountData.getId()));
            list.add(accountData.getName());
            list.add(accountData.getMoney());
            list.add(accountData.getOriginMoney());
            list.add(accountData.getRemark());
            list.add(accountData.getAccountType());
        }

        return list;
    }


}

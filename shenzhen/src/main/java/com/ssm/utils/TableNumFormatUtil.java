package com.ssm.utils;

import java.text.DecimalFormat;

/**
 * 简单描述类的作用
 *
 * @author luocong
 * @create 2017-09-20 16:28
 **/
public class TableNumFormatUtil {


    public static String completionNumberFormat(int number) {
        DecimalFormat df = new DecimalFormat("_0000");
        String formatNumber = df.format(number);
        return formatNumber;
    }

    public static String completionNumberFormat2(int number) {
        DecimalFormat df = new DecimalFormat("_00");
        String formatNumber = df.format(number);
        return formatNumber;
    }
    
    public static String getTableSuffix(String businessId,long tableSize,String tableSuffix){
        long routeValue = Math.abs(businessId.hashCode());
        long index = routeValue%tableSize;
        String format = "%0"+(tableSuffix.length()-1)+"d";
        return "_"+String.format(format, index);
    }

    public static void main(String[] args) {
        String tab =completionNumberFormat(25);
        String tab2 = completionNumberFormat2(25);
        System.out.println(tab);
        System.out.println(tab2);
    }
}


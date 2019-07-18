package com.example.shiro.shiro.real;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(data("2019-07-12"));
    }

    public static String currentYearTime() {
        Date date = new Date();
        return YEARMONTHDAY_FORMAT.format(date);
    }


    public static final SimpleDateFormat YEARMONTHDAY_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");

    public static int data(String oldData){ // 计算俩个日期间隔多少天
        try {
            Date date1 = YEARMONTHDAY_FORMAT.parse(currentYearTime());
            Date date2 = YEARMONTHDAY_FORMAT.parse(oldData);
            return differentDays(date1,date2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return -1;
    }

    public static int differentDays(Date date1,Date date2){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
//        System.out.println(day1);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
//        System.out.println(day2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);

        if (year1 != year2)  //不同年
        {
            int timeDistance = 0;
            for (int i = year1 ; i < year2 ;i++){ //闰年
                if (i%4==0 && i%100!=0||i%400==0){
                    timeDistance += 366;
                }else { // 不是闰年
                    timeDistance += 365;
                }
            }
            return  timeDistance + (day2-day1);
        }else{// 同年
            return day2-day1;
        }

    }
}

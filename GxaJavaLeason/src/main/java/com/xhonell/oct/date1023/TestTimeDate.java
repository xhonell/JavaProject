package com.xhonell.oct.date1023;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 * day6.TestTimeDate
 * User: hly
 * Date: 2024/10/23 15:10
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestTimeDate {
    public static void main(String[] args) {
        //Time  时间
        LocalTime time = LocalTime.now();
        System.out.println(time);
        time = LocalTime.of(8, 30, 0);
        //  日期
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //获取月份对象
        Month month = date.getMonth();
        //              获取
        System.out.println(month.getValue());
        System.out.println(date.isLeapYear());//是不是闰年

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        //固定获取一个2020-12-12  12:12:12
        LocalDate date1 = LocalDate.of(2020, 12, 12);
        LocalDateTime dateTime = LocalDateTime.of(2020, 12, 12, 12, 12, 12);
        System.out.println(dateTime);
        //Date 获取时间(年月日时分秒)
        Date date2 = new Date();//获取当前时间
        System.out.println(date2);
        System.out.println(date2.getMonth() + 1);//0-11
        date2.setTime(1000);
        //1970  08:00:00
        System.out.println(date2);//东八区
        //记录这一年所有的信息     当前的时间信息
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        date2 = new Date();//2024
        Date date3 = new Date(2000);//1970
        System.out.println(date2.before(date3));//false
        System.out.println(date2.after(date3));//true

        calendar.set(2022, 11, 10);// 0-11
        calendar.add(Calendar.DATE, 40);
        System.out.println(calendar.getTime());//12 19

        calendar.set(2022, 16, 32);// 0-11
        System.out.println(calendar.getTime());//12 19


    }
}

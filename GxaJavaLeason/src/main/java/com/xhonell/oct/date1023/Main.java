package com.xhonell.oct.date1023;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class Main {

    /**
     * 测试类：测试课堂学习进度
     */
    @Test
    public void studyClassTest() {
        System.out.println(2.0 - 1.1);
        /*精度丢失要使用字符串的构造器*/
        BigDecimal bd1 = new BigDecimal("2.0");
        BigDecimal bd2 = new BigDecimal("1.1");
        System.out.println(bd1.subtract(bd2));
    }

    /**
     * 测试类：测试系统类学习进度
     * description:
     * SimpleDateFormat:格式化时间格式
     * format(Date date):将Date类型的时间格式化为String类型的时间
     * parse(String str):将String类型的时间格式化为Date类型的时间
     * DateTimeFormatter:格式化时间格式
     */
    @Test
    public void StudySystemTest() {
        System.err.println("Error Message");

        /*LocalTime类:获取当前时间*/
        LocalTime now = LocalTime.now();
        now = LocalTime.of(12, 30, 59);
        System.out.println(now);

        /*LocalTime类:获取当前日期*/
        LocalDate date = LocalDate.now();
        System.out.println(date);
        Integer month = date.getMonthValue();
        System.out.println(month);
        System.out.println(date.isLeapYear());

        /*Calendar类:获取当前时间，记录这一年的信息*/
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        LocalDate bornTime = LocalDate.of(2003, 8, 4);
        BornTime time = new BornTime(bornTime);
        System.out.println(time.getBornTime());
    }

}

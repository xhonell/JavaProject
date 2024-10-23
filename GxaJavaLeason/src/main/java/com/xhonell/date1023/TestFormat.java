package com.xhonell.date1023;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * day6.TestFormat
 * User: hly
 * Date: 2024/10/23 16:14
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestFormat {
    public static void main(String[] args) throws ParseException {//抛出异常
        //日期格式化类 指定格式                               "yy-M-d ah:m"
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yy-M-d ah:m");//"yyyy年MM月d日HH点mm分ss秒 E"
        //日期对象
        Date  date=new Date();
        System.out.println(date);
        //把日期进行格式化解析
        String time = simpleDateFormat.format(date);
        System.out.println(time);
        //字符串类型
        time="2020-12-12";
        //实例格式对象
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");//("yyyy/MM/dd");//ParseException 解析错误
        //把字符串对象转换成 Date日期对象
        Date date1 = simpleDateFormat.parse(time);
        System.out.println(date1);

        LocalDate  localDate=LocalDate.of(2022,2,12);
        System.out.println(localDate);//2022-02-12
        LocalDateTime  dateTime=LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        //  一定字符串  -
        String   money="100,100.34";//
       // System.out.println(Double.parseDouble(money));
        //数字格式化类
        DecimalFormat  decimalFormat=new DecimalFormat();
        //把按指定格式解析成基本数据类型
        double  mon=decimalFormat.parse(money).doubleValue();
        money="222%";//
        mon=0.03;
        decimalFormat=new DecimalFormat("#,###.00%");//#,###.00
        //把数字按指定格式转换字符串对象
        System.out.println(decimalFormat.format(mon));
        decimalFormat=new DecimalFormat("#,###");//"#,###"
        mon=9999.49;
        System.out.println(decimalFormat.format(mon));//四舍五入了


    }
}

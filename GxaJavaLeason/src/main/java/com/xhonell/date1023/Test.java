package com.xhonell.date1023;

/**
 * day6.wk.Test
 * User: hly
 * Date: 2024/10/23 10:41
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class Test {
    public static void main(String[] args) {
        //基本数据类型 如果转换成包装类型(引用数类型)
        // 装箱:基本数据类型 转换为包装类型   和  拆箱:包装类型转换为基本数据类型
        int i = 12;
        //构造器
        Integer i3 = new Integer(i);//原来的写法
        Integer i2 = i;//装箱    目前最常用的写法   基本数据类型对应的包装类 可以直接进行转换
        i = i3.intValue();//原来的写法
        i = i3;//拆箱  目前最常用的写法

//        byte  b=12;
//        Integer  i4=b;

        //字符串数字如何转换为 基本数据类型
        Integer integer = new Integer("22");
        i = integer;//不怎么用

        i = Integer.parseInt("123");//常用  NumberFormatException
        System.out.println(i);
        //
        String str = Integer.toString(12);// 1+"";
        //                      把数字转换为16进制    Object  toString()
        System.out.println(Integer.toHexString(15));
        System.out.println(Integer.toOctalString(15));
        System.out.println(Integer.toBinaryString(6));


    }
}

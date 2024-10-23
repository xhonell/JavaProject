package com.xhonell.date1023;

/**
 * day6.TestDouble
 * User: hly
 * Date: 2024/10/23 11:11
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestDouble {
    public static void main(String[] args) {
        //定义
        double d = 12.4;
        Double d2 = d;// 装箱
        d = d2;//拆箱
        d = Double.parseDouble("12.33");//把字符窜转换为 基本数据类型
        d2 = Double.parseDouble("12.33");//把字符窜转换为 基本数据类型 然后装箱
    }
}

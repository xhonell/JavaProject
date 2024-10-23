package com.xhonell.date1023;

import java.math.BigDecimal;

/**
 * day6.TestBigDecimal
 * User: hly
 * Date: 2024/10/23 11:20
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        System.out.println(2.0-1.1);//0.9  发生精度丢
        //  防止精度丢失  构造器使用字符串
        BigDecimal  bigDecimal=new BigDecimal(2.0+"");
        BigDecimal  bigDecimal1=new BigDecimal("1.1");
        System.out.println(bigDecimal.subtract(bigDecimal1));

    }
}

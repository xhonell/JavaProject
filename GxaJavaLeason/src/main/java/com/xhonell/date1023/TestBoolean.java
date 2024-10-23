package com.xhonell.date1023;

/**
 * day6.TestBoolean
 * User: hly
 * Date: 2024/10/23 11:16
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestBoolean {
    public static void main(String[] args) {
        Boolean b = new Boolean("false");//null   false
        // System.out.println(b);
        Integer i3 = 12;
        Integer i4 = 12;
        Integer i1 = new Integer(12);
        Integer i2 = new Integer(12);
        System.out.println(i1.toString());
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        System.out.println(i1 == i2);//不是同一个对象
        System.out.println(i3 == i2);//基本数据类型 和对象比
        System.out.println(i3 == i4);//数值和数值

    }
}

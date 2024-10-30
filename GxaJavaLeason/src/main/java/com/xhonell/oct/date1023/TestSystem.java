package com.xhonell.oct.date1023;

import java.util.Arrays;

/**
 * day6.TestSystem
 * User: hly
 * Date: 2024/10/23 14:56
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class TestSystem {
    public static void main(String[] args) {
        //基准时间  1970 1月1号 00:00:00  000                             1729667320503
        System.out.println(System.currentTimeMillis());//获得当前的时间戳毫秒值  1729667176659
        //

        int[] arr = {1, 2, 4, 3, 5};
        int[] newArr = new int[9];//{2,4,3,0,0,0,0,0}
        System.arraycopy(arr, 1, newArr, 0, 4);//ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(newArr));
        a();
        System.out.println("==========================");
        // 线程
//        for (int i = 0; i < 100; i++) {
//            System.out.println("输出信息");
//            System.err.println("报错信息");
//            System.out.println("输出信息");
//        }
    }

    public static void a() {
        System.out.println("===a");
        System.exit(0);//终止java 虚拟机
    }
}

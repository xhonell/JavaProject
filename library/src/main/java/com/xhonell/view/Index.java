package com.xhonell.view;

import java.util.Scanner;

/**
 * <p>Project:JavaProject - Index
 * <p>POWER by xhonell on 2024-11-08 09:26
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Index {
    public static final Scanner scanner = new Scanner(System.in);
    public void index() {
        System.out.println("======欢迎使用图书管理系统======");
        System.out.println("请选择您要进行的操作：\n\t1、登录\n\t2、取消");
        IndexChoose indexChoose = new IndexChoose();
        System.out.print("请输入您的选择:");
        while (true) {
            Integer chooseInt = scanner.nextInt();
            switch (chooseInt) {
                case 1:
                    indexChoose.login();
                    return;
                case 2:
                    indexChoose.cancel();
                    return;
                default:
                    System.out.print("输入错误,请重新输入:");
                    break;
            }
        }
    }
}

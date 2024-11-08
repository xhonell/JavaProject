package com.xhonell.nov.date1106.HomeWork;


import static com.xhonell.oct.date1015.Shopping.scanner;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-11-06 18:01
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {
    /**
     * 测试sql数据库
     * @param args
     */
    public static void main(String[] args) {
       index();
    }
    public static void index(){
        System.out.println("请选择你要进行的操作：\n\t1、登录\n\t2、注册");
        Menu menu = new Menu();
        System.out.print("我的选择是：");
        Integer chooseByte = scanner.nextInt();

        while (true) {
            switch (chooseByte) {
                case 1:
                    menu.login();
                    break;
                case 2:
                    menu.register();
                    break;
                default:
                    System.out.print("输入有误，请重新输入：");
                    chooseByte = scanner.nextInt();
                    break;
            }
        }
    }
}

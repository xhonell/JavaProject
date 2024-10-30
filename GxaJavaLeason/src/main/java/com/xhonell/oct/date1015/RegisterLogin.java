package com.xhonell.oct.date1015;

import java.util.Scanner;

/**
 * day7.com.xhonell.data1015.RegisterLogin
 * User: hly
 * Date: 2024/10/14 16:11
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class RegisterLogin {
    //全局变量
    public static void main(String[] args) {
        //定义二维数组  为了存储 用户数据信息
        String[][] name_password = new String[3][2];//{{null,null,"正常"},{null,null,"锁定"},{null,null}...}
        choose(name_password);

    }

    /**
     * 注册
     * 请输入
     * 然后输入的数据放入  name_password数组中
     *
     * @param name_password
     */
    public static void register(String[][] name_password) {//{{"李磊","123"},{韩梅梅,123},{null,null}...}
        System.out.println("==================注册界面==========================");
        System.out.println("请输入用户名:");//韩梅梅  不能重复
        String name = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();//123
        //是否存储成功
        boolean t = false;
        //循环二维数组
        for (int i = 0; i < name_password.length; i++) {
            //判断数组内容是否为null
            if (name_password[i][0] == null) {
                //存储
                name_password[i][0] = name;
                name_password[i][1] = password;
                t = true;
                break;
            }
        }
        //判断标签是否被改变
        if (t) {
            System.out.println(name + "注册成功");
            choose(name_password);
        } else {
            System.out.println(name + "注册失败,人员已满,请换服务器重试.");
        }

    }

    /**
     * 请输入
     * 判断输入的信息是否在 数组中
     *
     * @param name_password
     */
    public static void login(String[][] name_password) {
        System.out.println("==================登录界面==========================");
        System.out.println("请输入用户名:");//韩梅梅
        String name = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();//123
        //判断验证是否存在于数组中
        int index = -1;
        //循环遍历数组
        for (int i = 0; i < name_password.length; i++) {//{{"李磊","123"},{韩梅梅,123},{null,null}...}
            if (name.equals(name_password[i][0]) && password.equals(name_password[i][1])) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(name + "登录成功,进入主页面");
            indexChoose(name_password, index);//不太符合常规
        } else {
            System.out.println("用户名或者密码错误,请重新输入");
            login(name_password);
        }
    }

    /**
     * 选择
     * 1.注册
     * 2.登录
     *
     * @param name_password
     */
    public static void choose(String[][] name_password) {
        System.out.println("================登录/注册  界面=======================");
        System.out.println("1.注册\n" +
                "2.登录");
        String choose = scanner.next();
        //判断选择
        if ("1".equals(choose)) {
            register(name_password);
        } else if ("2".equals(choose)) {
            login(name_password);
        } else {
            System.out.println("您输入错误,请重新选择");
            choose(name_password);//调用自己
        }

    }

    /**
     * 1.查询所有用户
     * 2.修改密码
     */
    public static void indexChoose(String[][] name_password, int index) {//index当前用户信息存储在数组中那个位置
        System.out.println("==============主界面========================");
        System.out.println("1.查询所有用户\n" + "2.修改密码\n" + "3.选购商品\n" + "4.退出");
        String choose = scanner.next();
        if ("1".equals(choose)) {
            printlnAll(name_password);
        } else if ("2".equals(choose)) {
            updatePassword(name_password, index);
            return;
        } else if ("3".equals(choose)) {
            Shopping.shopping(name_password, index);
            return;
        } else if ("4".equals(choose)) {
            return;
        } else {
            System.out.println("您输入错误,请重新选择");
        }
        indexChoose(name_password, index);
    }


    /**
     * 查看所有用户
     *
     * @param name_password
     */
    public static void printlnAll(String[][] name_password) {
        System.out.println("===========展示用户信息===================");
        for (int i = 0; i < name_password.length; i++) {
            if (name_password[i][0] != null) {
                System.out.println(name_password[i][0]);
            }
        }
    }


    /**
     * 修改密码
     *
     * @param name_password 存储所有用户信息
     * @param index         当前用户的下标
     */
    public static void updatePassword(String[][] name_password, int index) {
        System.out.println("请原密码:");
        String oldPassword = scanner.next();
        System.out.println("请输入新密码");
        String newPassword = scanner.next();
        //判断存储中的密码是原密码是否相同
        if (oldPassword.equals(name_password[index][1])) {
            //比较新密码和原密码是否相同
            if (oldPassword.equals(newPassword)) {
                System.out.println("原密码不能和新密码相同");
                updatePassword(name_password, index);
            } else {
                name_password[index][1] = newPassword;
                login(name_password);
            }
        } else {
            if (count == 3) {
                System.out.println("密码错误次数过多请重新进入系统");
                choose(name_password);
            } else {
                System.out.println("原密码输入错误");
                count++;
                updatePassword(name_password, index);
            }
        }
    }

    // 类中可以定义  静态方法   静态主函数   静态变量
    static Scanner scanner = new Scanner(System.in);
    static int count = 1;

}

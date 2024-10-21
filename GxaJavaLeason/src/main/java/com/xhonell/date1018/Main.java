package com.xhonell.date1018;

import org.junit.Test;

public class Main {

    /**
     * 测试类:测试Account的账户封装
     */
    @Test
    public void accountTest() {
        Account account = new Account(1001, 20000.0, "abcabc");
        account.setPassWord("123456");
        System.out.println(account.toString());
    }

    /**
     * 测试类:测试Square（正方形）的面积计算
     */
    @Test
    public void squareTest() {
        Square square = new Square(5);
        System.out.println(square.area());
    }

    @Test
    public void circleTest() {
        Circle circle = new Circle(5);
        System.out.println(circle.area());
        System.out.println(circle.girth());
    }

}

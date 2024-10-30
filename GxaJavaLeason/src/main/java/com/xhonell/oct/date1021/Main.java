package com.xhonell.oct.date1021;

import org.junit.Test;

public class Main {
    //public 当前项目所有类都可以访问
    //private 只有本类可以访问
    //protected 只有当前包下的类和其他包下的子类可以访问
    //default 只有当前包下的类可以访问

    /**
     * 测试类：测试Teacher类的重写方法
     */
    @Test
    public void teacherTest() {
        Teacher t1 = new Teacher("张三", 25, 6500, "语文");
        Teacher t = new Teacher("李四", 25, 6500, "语文");
        System.out.println(t.hashCode());
        System.out.println(t.equals(t1));
        System.out.println(t);
    }
}
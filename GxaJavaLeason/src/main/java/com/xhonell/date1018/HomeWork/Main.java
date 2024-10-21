package com.xhonell.date1018.HomeWork;

import org.junit.Test;

public class Main {

    /**
     * 测试类：测试fileName方法
     */
    @Test
    public void fileNameTest() {
        System.out.print("请输入文件路径：");

        /*模拟输入*/
        System.out.println("E:\\2百杰班\\183\\一阶段二维数组.png");
        String fileAddress = "E:\\2百杰班\\183\\一阶段二维数组.png";
        FileName fileName = new FileName(fileAddress);
        System.out.println(fileName.getFileName());
    }

    /**
     * 测试类：测试employee方法
     * 当前月份我10月
     */
    @Test
    public void employeeTest() {
        SalesEmployee salesEmployee = new SalesEmployee("张三", 1, 12780, 0.1);
        System.out.println(salesEmployee.totalSalary());

        HourlyEmployee hourlyEmployee = new HourlyEmployee("李四", 2, 20, 180);
        System.out.println(hourlyEmployee.totalSalary());

        SalariedEmployee salariedEmployee = new SalariedEmployee("王五", 3, 12000);
        System.out.println(salariedEmployee.totalSalary());

        BasePlusSalesEmployee basePlusSalesEmployee = new BasePlusSalesEmployee("赵六", 4, 12000, 0.1, 1000);
        System.out.println(basePlusSalesEmployee.totalSalary());
    }

    /**
     * 测试类：测试user方法
      */

    @Test
    public void userTest() {
        User user = new User("换挡杆哦啊红烧冬瓜闹啥代发", "$hH1956321478");
        user.register();
    }

}

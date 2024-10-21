package com.xhonell.date1018.HomeWork;

import lombok.Data;

/**
 * Employee：这是所有员工总的父类，属性：员工的姓名,员工的生日月份。方法：
 * getSalary(intmonth) 根据参数月份来确定工资，如果该月员工过生日，则公司
 * 会额外奖励100 元
 */
@Data
public class Employee {
    private String employeeName;
    private int employeeBorn;

    public Employee() {
    }

    public Employee(String employeeName, int employeeBorn) {
        this.employeeName = employeeName;
        this.employeeBorn = employeeBorn;
    }

    /**
     * 判断是否为生日月份
     *
     * @param month
     * @return
     */
    public int addSalary(int month) {
        if (month == 10)
            return 100;
        else return 0;
    }

    public double totalSalary() {
        return 0;
    }
}

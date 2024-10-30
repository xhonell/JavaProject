package com.xhonell.oct.date1018.HomeWork;

import lombok.Data;

/**
 * Employee 的子类，销售人员，工资由月销售额和提成率决定。
 * 属性：月销售额、提成率
 */

@Data
public class SalesEmployee extends Employee {
    private double employeeSalary;
    private double employeeSale;

    public SalesEmployee(String employeeName, int employeeBorn, double employeeSalary, double employeeSale) {
        super(employeeName, employeeBorn);
        this.employeeSalary = employeeSalary;
        this.employeeSale = employeeSale;
    }


    @Override
    public double totalSalary() {
        return employeeSale * employeeSalary + addSalary(super.getEmployeeBorn());
    }
}

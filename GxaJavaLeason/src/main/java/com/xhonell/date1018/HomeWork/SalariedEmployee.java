package com.xhonell.date1018.HomeWork;

import lombok.Data;

/**
 * SalariedEmployee：Employee 的子类，拿固定工资的员工。属性：月薪
 */

@Data
public class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String employeeName, int employeeBorn, double salary) {
        super(employeeName, employeeBorn);
        this.salary = salary;
    }

    @Override
    public double totalSalary() {
        return salary + addSalary(getEmployeeBorn());
    }
}

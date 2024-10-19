package com.xhonell.data1018.HomeWork;

/**
 * SalesEmployee 的子类，有固定底薪的销售人员，工
 * 资由底薪加上销售提成部分。属性：底薪。
 */
public class BasePlusSalesEmployee extends SalesEmployee {
    private double baseSalary;

    public BasePlusSalesEmployee(String employeeName, int employeeBorn, double employeeSalary, double employeeSale, double baseSalary) {
        super(employeeName, employeeBorn, employeeSalary, employeeSale);
        this.baseSalary = baseSalary;
    }

    @Override
    public double totalSalary() {
        return baseSalary + getEmployeeSale() * getEmployeeSalary() + addSalary(getEmployeeBorn());
    }

}

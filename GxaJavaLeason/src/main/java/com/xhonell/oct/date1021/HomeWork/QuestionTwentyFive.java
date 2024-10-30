package com.xhonell.oct.date1021.HomeWork;

import com.xhonell.oct.date1018.HomeWork.*;

public class QuestionTwentyFive {

    public void employeeSalary() {
        Employee[] employees = new Employee[]{
                new HourlyEmployee("张三", 10, 18, 320),
                new SalariedEmployee("李四", 9, 2800),
                new SalesEmployee("王五", 7, 46000, 0.12),
                new BasePlusSalesEmployee("赵六", 8, 50000, 0.1, 300)
        };

        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeName() + "的工资是：" + employee.totalSalary());
        }
    }
}

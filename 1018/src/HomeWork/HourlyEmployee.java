package HomeWork;

import lombok.Data;

/**
 * 按小时拿工资的员工，每月工作超出160 小
 * 时的部分按照1.5 倍工资发放。属性：每小时的工资、每月工作的小时数
 */
@Data
public class HourlyEmployee extends Employee {
    private double hourlySalary;
    private double hourlyHours;

    public HourlyEmployee(String employeeName, int employeeBorn, double hourlySalary, double hourlyHours) {
        super(employeeName, employeeBorn);
        if (hourlyHours <= 160) {
            this.hourlySalary = hourlySalary;
            this.hourlyHours = hourlyHours;
        } else if (hourlyHours > 160 && hourlyHours <= 840) {
            this.hourlySalary = hourlySalary * 1.5;
            this.hourlyHours = hourlyHours;
        } else {
            System.out.println("您是神仙吗？");
        }
    }

    @Override
    public double totalSalary() {
        return hourlySalary * hourlyHours + addSalary(getEmployeeBorn());
    }
    
    /*public String toString(){
        return "HourlyEmployee{" +
                "employeeName='" + getEmployeeName() + '\'' +
                ", employeeBorn=" + getEmployeeBorn() +
                ", hourlySalary=" + hourlySalary +
                ", hourlyHours=" + hourlyHours +
                ", totalSalary=" + totalSalary() +
                '}';
    }*/

}

package com.xhonell.date1030.HomeWork;

import lombok.Data;

/**
 * <p>Project:JavaProject - Student
 * <p>POWER by xhonell on 2024-10-30 22:36
 * <p>description：一个普普通通的学生类
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private Double salary;
    private String classNum;

    public Student(String name, Integer age, Double salary, String classNum) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.classNum = classNum;
    }
}

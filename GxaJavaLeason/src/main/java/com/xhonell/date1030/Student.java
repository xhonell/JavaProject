package com.xhonell.date1030;

import lombok.Data;

import java.util.Objects;

/**
 * <p>Project:JavaProject - Student
 * <p>POWER by xhonell on 2024-10-29 16:33
 * description：学生类
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */

@Data
public class Student {
    private String name;
    private Integer age;
    private Integer salary;
    private String lessonName;

    public Student() {
    }

    public Student(String name, Integer age, Integer salary, String lessonName) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.lessonName = lessonName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(lessonName, student.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, lessonName);
    }
}

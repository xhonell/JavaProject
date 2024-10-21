package com.xhonell.date1021;

import lombok.Data;

@Data
public class Teacher {
    private String name;
    private int age;
    private double salary;
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, double salary, String subject) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() + age : age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj instanceof Teacher) {
            Teacher t = (Teacher) obj;
            if (t.name != null && t.subject != null) {
                return name.equals(t.name) && age == t.age && salary == t.salary && subject.equals(t.subject);
            } else return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + ", salary=" + salary + ", subject=" + subject + "]";
    }
}

package com.xhonell.data1016;

public class Persons {
    private String name;
    private int age;
    private String gender;

    public Persons(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Persons() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + gender;
    }
}

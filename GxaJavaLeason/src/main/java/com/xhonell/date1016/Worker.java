package com.xhonell.date1016;

public class Worker {
    private String name;
    private int age;
    private double salary;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Worker(String name, int age, double salary, Address address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public Worker() {
    }

    public void work() {
    }

    public int work(int hours) {
        return hours;
    }

    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary + address.toString() +
                '}';
    }
}

package com.xhonell.date1029.HomeWork;

import lombok.Data;

/**
 * <p>Project:JavaProject - Work
 * <p>POWER by xhonell on 2024-10-29 16:51
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
public class Worker {
    private int age;
    private String name;
    private double salary;

    public Worker() {
    }

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + "work");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age && Double.compare(worker.salary, salary) == 0;
    }
}

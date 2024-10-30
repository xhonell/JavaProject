package com.xhonell.oct.date1022.HomeWork;

import lombok.Data;

@Data
abstract class NameRole implements Role {
    public String name;
    public int age;

    public NameRole(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public NameRole() {
    }
}

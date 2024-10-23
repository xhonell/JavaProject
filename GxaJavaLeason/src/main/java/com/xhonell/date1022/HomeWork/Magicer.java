package com.xhonell.date1022.HomeWork;

import lombok.Data;

@Data
public class Magicer extends NameRole {
    private int level;
    private MagicStick stick;

    public Magicer(String name, int age, int level) {
        super(name, age);
        this.level = level;
        this.stick = stick;
    }

    public Magicer() {
    }

    @Override
    public int attack() {
        return level * 5;
    }

    @Override
    public void practise() {
        if (stick == null)
            level++;
        else
            level += 1 + stick.fire();
    }

    public void setLevel(int level) {
        if (level >= 1 && level <= 10)
            this.level = level;
    }
}

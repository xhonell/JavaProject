package com.xhonell.oct.date1022.HomeWork;

public class Bolo implements Weapon {
    private Soldier soldier;

    public Bolo() {
    }

    public Bolo(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int fire() {
        //当 soldier 的年龄大于等于 18 岁时，fire 方法返回 100
        //当 soldier 年龄小于 18 岁时，fire 方法返回 50
        return soldier != null ? (soldier.getAge() >= 18 ? 100 : 50) : 0;
    }

    @Override
    public void setSolider(Soldier s) {
        this.soldier = s;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }
}

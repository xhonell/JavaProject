package com.xhonell.date1022.HomeWork;

public class Pick implements Weapon {

    private String name;
    private Soldier soldier;

    @Override
    public int fire() {
        //当长矛的名字和战士的名字一致时，fire 方法返回 1000；
        //当长矛的名字和战士的名字不一致时，fire 方法返回 25
        if (name != null && soldier != null && name.equals(soldier.getName())) {
            return 1000;
        } else if (soldier != null) {
            return 25;
        }
        return 0;//  没有持长矛人
    }

    @Override
    public void setSolider(Soldier s) {
        this.soldier = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }
}

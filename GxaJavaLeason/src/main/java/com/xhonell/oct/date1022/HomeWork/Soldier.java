package com.xhonell.oct.date1022.HomeWork;

import lombok.Data;

@Data
public class Soldier extends NameRole {
    private int hurt;
    private Weapon weapon;

    public Soldier() {
    }

    public Soldier(String name, int age, int hurt, Weapon weapon) {
        super(name, age);
        this.hurt = hurt;
        this.weapon = weapon;
    }

    @Override
    public int attack() {
        //武器的复制 持刀或者 持长矛 人
        weapon.setSolider(this);
        //i. Soldier 的 attack 返回值为战士的 hurt 值与武器的 fire 方法返
        //回值的和，即 总攻击输出 = 战士的徒手伤害值 + 武器的伤害值
        //ii. practise()方法：每调用一次则战士的 hurt 值+10
        return hurt + (weapon != null ? weapon.fire() : 0);
    }

    @Override
    public void practise() {
        hurt += 10;
    }


}

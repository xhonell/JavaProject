package com.xhonell.oct.date1022.HomeWork;

import org.junit.Test;

public class Main {

    @Test
    public void teamTest() {
        Magicer magicer = new Magicer("张三", 35, 8);
        Weapon weapon = new Pick();
        Pick pick = (Pick) weapon;
        pick.setName("神奇的棒棒糖");
        Soldier soldier = new Soldier("李四", 25, 10, pick);
        Team team = new Team();
        team.addMember(magicer);
        team.addMember(soldier);
        System.out.println("小队攻击力：" + team.attackSum());
    }
}

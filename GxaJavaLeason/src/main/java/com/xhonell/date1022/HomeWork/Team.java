package com.xhonell.date1022.HomeWork;

import java.util.Arrays;

public class Team {
    public static int teamCount = 0;
    public static Role[] teamMenber = new Role[6];

    public void addMember(Role role) {
        if (role != null) {
            if (teamCount < 6)
                teamMenber[teamCount++] = role;
            else System.out.println("列表已满");
        } else System.out.println("角色为空");
    }

    public int attackSum() {
        int sum = 0;

        for (Role role : Arrays.copyOf(teamMenber, teamCount)) {
            sum += role.attack();
        }
        return sum;
    }
}

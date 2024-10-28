package com.xhonell.date1028.HomeWork;

/**
 * <p>Project:JavaProject - TortoiseHare
 * <p>POWER by xhonell on 2024-10-28 18:50
 * description：龟兔赛跑
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class TortoiseHare {
    public static final int LENGTH = 100; // 比赛总距离
    private int tortoiseDistance = 0; // 乌龟当前距离
    private int hareDistance = 0; // 兔子当前距离

    public synchronized void runRace() {
        while (tortoiseDistance < LENGTH && hareDistance < LENGTH) {
            double random = Math.random();
            if (random <= 0.3) { // 兔子跑
                hareDistance += 2;
                System.out.println("兔子跑了 2 米，总共跑了 " + hareDistance + " 米");
            } else { // 乌龟跑
                tortoiseDistance += 1;
                System.out.println("乌龟跑了 1 米，总共跑了 " + tortoiseDistance + " 米");
            }

            // 检查是否有选手到达终点
            if (hareDistance >= LENGTH) {
                System.out.println("兔子赢了比赛!");
            } else if (tortoiseDistance >= LENGTH) {
                System.out.println("乌龟赢了比赛!");
            }

            // 模拟比赛间隔
            try {
                Thread.sleep(100); // 每次跑步后等待 100 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TortoiseHare race = new TortoiseHare();
        race.runRace(); // 开始比赛
    }
}

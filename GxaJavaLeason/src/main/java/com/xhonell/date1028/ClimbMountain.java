package com.xhonell.date1028;

/**
 * <p>Project:JavaProject - ClimbMountain
 * <p>POWER by xhonell on 2024-10-28 18:03
 * description：爬山线程
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class ClimbMountain implements Runnable{
    private static final int HEIGHT_MOUNTAIN = 1000;

    @Override
    public void run() {
        int mountain = 0;
        while(mountain < HEIGHT_MOUNTAIN){
            if (mountain % 200 == 0)
                try {
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            mountain += 100;
            System.out.println(Thread.currentThread().getName() + "已经爬了：" + mountain);
        }
    }
}

package com.xhonell.oct.date1028;

/**
 * <p>Project:JavaProject - Main
 * <p>POWER by xhonell on 2024-10-28 11:59
 * description：JavaSE Thead 线程
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Main {

    /**
     * 买票
     *
     * @param args
     */
    public static void main(String[] args) {
        SaleTicket saleTicket_01 = new SaleTicket("线程一");
        SaleTicket saleTicket_02 = new SaleTicket("线程二");
        SaleTicket saleTicket_03 = new SaleTicket("线程三");

        saleTicket_01.start();
        saleTicket_02.start();
        saleTicket_03.start();
    }

    /**
     * 爬山
     * @param args
     */
    /*public static void main(String[] args) {
        ClimbMountain climbMountain = new ClimbMountain();
        Thread threadYoung = new Thread(climbMountain, "年轻人");
        Thread threadAgedness = new Thread(climbMountain, "老年人");

        threadYoung.setPriority(8);

        threadYoung.start();
        threadAgedness.start();
    }*/


}

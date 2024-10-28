package com.xhonell.date1028;

/**
 * <p>Project:JavaProject - SaleTicket
 * <p>POWER by xhonell on 2024-10-28 16:51
 * description：售票线程
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class SaleTicket extends Thread{
    final Ticket ticket = new Ticket();

    public SaleTicket(String name){
        super(name);
    }
    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ticket.saleTicket() != -1){
                System.out.println(getName() + "售出票号：" + Ticket.ticket);
            }else break;
        }
    }
}

package com.xhonell.date1028;

import lombok.Data;

/**
 * <p>Project:JavaProject - ticket
 * <p>POWER by xhonell on 2024-10-28 16:46
 * description：票
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
public class Ticket {
    private static final int MIN_TICKET = 1;
    private static final int MAX_TICKET = 100;
    public static int ticket = MAX_TICKET;

    public synchronized int saleTicket(){
        if (--ticket >= MIN_TICKET && ticket <= MAX_TICKET){
            return ticket;
        }
        return -1;
    }
}

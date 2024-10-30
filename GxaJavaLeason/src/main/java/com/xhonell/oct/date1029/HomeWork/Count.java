package com.xhonell.oct.date1029.HomeWork;

/**
 * <p>Project:JavaProject - Count
 * <p>POWER by xhonell on 2024-10-29 17:20
 * description：银行账户类
 * idea: 提供线程安全的存钱方法和取钱方法
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */

public class Count {
    private Double balance = 0.0;

    /**
     * 取钱方法
     *
     * @param getBalance
     * @return Double balance
     */
    public synchronized double getBalance(Double getBalance) {
        while (balance <= getBalance) {
            try {
                System.out.println("账户余额不足，进入等待");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance -= getBalance;
        if (balance <= 2000) notifyAll();
        System.out.println("账户支出:" + getBalance + "目前余额" + balance);
        return balance;
    }

    /**
     * 存钱方法
     *
     * @param setBalance
     * @return Double balance
     */
    public synchronized double setBalance(Double setBalance) {
        if (balance >= 2000) {
            try {
                System.out.println("账户余额过剩，进入等待");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        balance += setBalance;
        System.out.println("向账户转账:" + setBalance + "目前余额" + balance);
        if (balance >= 0.0) notifyAll();
        return balance;
    }
}

/**
 * 测试方法
 */
class countThreadTest {
    public static void main(String[] args) {
        Count count = new Count();
        /*存钱线程：最多存10000休眠*/
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    count.setBalance(100.0);
                }
            }
        }).start();

        /*取钱线程：没钱就滚*/
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Thread.yield();
                    count.getBalance(50.0);
                }
            }
        }).start();
    }
}

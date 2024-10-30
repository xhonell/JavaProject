package com.xhonell.oct.date1029;

public class Container {
    private Noodle noodle;

    public synchronized void productNoodle() {
        while (noodle != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        noodle = new Noodle();
        System.out.println("生产：" + noodle);
        notifyAll();
    }

    public synchronized void consumeNoodle() {
        while (noodle == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("消费：" + noodle);
        noodle = null;
        notifyAll();
    }
}

class NoodleMain {
    public static void main(String[] args) {
        Container container = new Container();

        Thread product = new Thread(() -> {
            while (true) {
                container.productNoodle();
            }
        });

        Thread consume = new Thread(() -> {
            while (true) {
                container.consumeNoodle();
            }
        });

        product.start();
        consume.start();
    }
}



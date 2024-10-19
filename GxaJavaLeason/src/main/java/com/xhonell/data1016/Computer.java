package com.xhonell.data1016;

public class Computer {
    private double num1;
    private double num2;

    public Computer(Double num1, Double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sum() {
        return num1 + num2;
    }

    public double sub() {
        return num1 - num2;
    }

    public double mul() {
        return num1 * num2;
    }

    public double div() {
        if (num2 == 0) {
            return 0.0;
        }
        return num1 / num2;
    }

    public double chooseMin() {
        return Math.min(num1, num2);
    }

    public boolean judge() {
        return num1 < num2;
    }
}

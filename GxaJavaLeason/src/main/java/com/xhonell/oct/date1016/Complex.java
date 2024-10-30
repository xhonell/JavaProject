package com.xhonell.oct.date1016;

public class Complex {
    //real： 虚数实部  imag：虚数虚部
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    public Complex add(double real) {
        return new Complex(this.real + real, this.imag);
    }

    public Complex sub(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    public Complex mul(Complex c) {
        double newReal = this.real * c.real - this.imag * c.imag;
        double newIm = this.real * c.imag + this.imag * c.real;
        return new Complex(newReal, newIm);
    }

    @Override
    public String toString() {
        return real + (imag >= 0 ? "+" : "") + imag + "i";
    }
}

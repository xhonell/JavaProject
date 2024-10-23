package com.xhonell.date1022.HomeWork;

abstract class Animal {
    public abstract void eat();
}

interface Pet {
    void play();
}

class Dog extends Animal implements Pet {
    public void eat() {

        System.out.println("Dog eat Bones ");
    }

    public void play() {
        System.out.println("Play with Dog ");
    }
}

class Cat extends Animal implements Pet {
    public void eat() {
        System.out.println("Cat eat fish");
    }

    public void play() {
        System.out.println("Play with Cat");
    }
}

class Wolf extends Animal {
    public void eat() {
        System.out.println("Wolf eat meat ");
    }
}

public class QuestionTen {
    public static void main(String args[]) {
        Animal as[] = new Animal[3];
        as[0] = new Dog();
        as[1] = new Cat();
        as[2] = new Wolf();

        for (Animal a : as) {
            a.eat();
            if (a instanceof Pet) {
                ((Pet) a).play();
            }
        }
    }
}
//1 处应该填入的代码为： //2 处应该填入的代码为：
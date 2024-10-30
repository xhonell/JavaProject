package com.xhonell.oct.date1021.HomeWork;

import java.util.Arrays;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class QuestionFourteen {
    public static void main(String args[]) {
        Animal[] as = new Animal[]{
                new Dog("Pluto"),
                new Cat("Tom"),
                new Dog("Snoopy"),
                new Cat("Garfield")
        };
        Dog[] dogs = getAllDog(as);
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].getName());
        }
    }

    public static Dog[] getAllDog(Animal[] as) {
        Dog[] dogs = new Dog[as.length];
        int count = 0;
        for (int i = 0; i < as.length; i++) {
            if (as[i] instanceof Dog) {
                dogs[count++] = (Dog) as[i];
            }
        }
        return Arrays.copyOf(dogs, count);
    }
}




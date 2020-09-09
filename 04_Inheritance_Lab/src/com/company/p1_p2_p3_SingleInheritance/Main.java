package com.company.p1_p2_p3_SingleInheritance;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.weep();
        puppy.bark();
    }
}

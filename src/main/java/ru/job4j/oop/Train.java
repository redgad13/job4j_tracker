package ru.job4j.oop;

public class Train extends Vehicle {
    @Override
    void move() {
        System.out.println("I ride on rails ");
    }

    @Override
    void refuel() {
        System.out.println("I consume coal");
    }
}

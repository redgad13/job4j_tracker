package ru.job4j.oop;

public class Bus extends Vehicle {
    @Override
    void move() {
        System.out.println("I drive on roads");
    }

    @Override
    void refuel() {
        System.out.println("I consume diesel");
    }
}

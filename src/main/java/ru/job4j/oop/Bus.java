package ru.job4j.oop;

public class Bus extends Vehicle {
    @Override
    public void move() {
        System.out.println("I drive on roads");
    }

    @Override
    public void refuel() {
        System.out.println("I consume diesel");
    }
}

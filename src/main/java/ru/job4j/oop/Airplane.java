package ru.job4j.oop;

public class Airplane extends Vehicle {
    @Override
    void move() {
        System.out.println("I believe I can fly");
    }

    @Override
    void refuel() {
        System.out.println("I believe I can touch the sky");
    }
}

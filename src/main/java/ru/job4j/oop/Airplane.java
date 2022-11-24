package ru.job4j.oop;

public class Airplane extends Vehicle {
    @Override
    public void move() {
        System.out.println("I believe I can fly");
    }

    @Override
    public void refuel() {
        System.out.println("I believe I can touch the sky");
    }
}

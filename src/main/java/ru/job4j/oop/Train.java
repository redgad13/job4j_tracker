package ru.job4j.oop;

public class Train extends Vehicle {
    @Override
    public void move() {
        System.out.println("I ride on rails ");
    }

    @Override
    public void refuel() {
        System.out.println("I consume coal");
    }
}

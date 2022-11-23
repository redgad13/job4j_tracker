package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Wrooooom-wrooooom");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("I have " + quantity + " passengers");
    }

    @Override
    public double fuel(double litres) {
        int price = 50;
        return litres * price;
    }
}

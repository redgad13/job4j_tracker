package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int quantity);

    double fuel(double litres);
}

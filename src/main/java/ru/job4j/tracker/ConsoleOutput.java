package ru.job4j.tracker;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object o) {
        System.out.println(o);
    }
}

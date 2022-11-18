package ru.job4j.oop;

public class Max {
    public static int max(int x, int y) {
        return Math.max(x, y);
    }

    public static int max(int x, int y, int z) {
        return Math.max(max(x, y), z);
    }

    public static int max(int x, int y, int z, int q) {
        return Math.max(max(x, y, z), q);
    }
}

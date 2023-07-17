package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Emulator e = new Emulator();
        System.out.println("Введите адрес каталога для кеширования");
        String dir = e.inputDirectory();
        AbstractCache dirFileCache = new DirFileCache(dir);
        System.out.println("Введите имя файла для кеширования или Exit для выхода");
        String file = e.inputFileName();
        while (!"exit".equals(file)) {
            System.out.println(dirFileCache.get(file));
            file = e.inputFileName();
        }
    }

    public String inputDirectory() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String inputFileName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
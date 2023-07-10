package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Emulator e = new Emulator();
        e.putData();
        DirFileCache dirFileCache = new DirFileCache(e.inputDirectory());
        String s = dirFileCache.get("test");
        System.out.println(s);

    }

    public String inputDirectory() {
        System.out.println("enter directory");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void putData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputDirectory()))) {
            System.out.println("Enter data");
            Scanner sc = new Scanner(System.in);
            bw.write(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

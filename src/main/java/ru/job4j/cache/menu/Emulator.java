package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.*;
import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Emulator e = new Emulator();
        System.out.println("Введите адрес каталога для кеширования");
        String dir = e.inputDirectory();
        System.out.println("Введите имя файла для кеширования или Exit для выхода");
        String file = e.inputFileName();
        while (!file.equals("exit")) {
            file = dir.concat("/").concat(file);
            DirFileCache dirFileCache = new DirFileCache(file);
            dirFileCache.put(file, e.getData(file));
            System.out.println(e.getData(file));
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

    public void putData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputDirectory()))) {
            Scanner sc = new Scanner(System.in);
            bw.write(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(String path) {
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                rsl.append(br.readLine());
                rsl.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl.toString();
    }
}

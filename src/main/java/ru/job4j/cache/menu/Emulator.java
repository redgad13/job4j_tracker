package ru.job4j.cache.menu;

import ru.job4j.cache.AbstractCache;
import ru.job4j.cache.DirFileCache;

import java.io.*;
import java.util.Scanner;

public class Emulator extends DirFileCache {

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public static void main(String[] args) {
        System.out.println("Введите адрес каталога для кеширования");
        String dir = inputDirectory();
        System.out.println("Введите имя файла для кеширования или Exit для выхода");
        String file = inputFileName();
        Emulator e = new Emulator(file);
        while (!file.equals("exit")) {
            file = dir.concat("/").concat(file);
            AbstractCache dirFileCache = new DirFileCache(file);
            if ("".equals(dirFileCache.get(file))) {
                dirFileCache.put(file, e.load(file));
            }  else {
                dirFileCache.get(file);
            }
            System.out.println(e.getData(file));
            file = inputFileName();
        }
    }

    public static String inputDirectory() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String inputFileName() {
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

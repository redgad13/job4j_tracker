package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache(".\\data\\new_file.txt");
        dirFileCache.get("test_text");
    }
}

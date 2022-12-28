package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        pred = f -> f.getSize() > 100 || f.getName().contains("bug");
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}
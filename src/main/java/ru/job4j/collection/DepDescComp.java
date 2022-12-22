package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftDeps = left.split("/");
        String[] rightDeps = right.split("/");
        int result = rightDeps[0].compareTo(leftDeps[0]);
        return result == 0 ? left.compareTo(right) : result;
    }
}

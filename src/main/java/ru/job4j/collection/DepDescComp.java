package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result;
        String[] leftDeps = left.split("/");
        String[] rightDeps = right.split("/");
        result = rightDeps[0].compareTo(leftDeps[0]);
        result = result == 0 ? left.compareTo(right) : result;
        return result;
    }
}

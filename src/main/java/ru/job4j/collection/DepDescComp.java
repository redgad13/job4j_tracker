package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < 2; i++) {
            result = Integer.compare(right.charAt(i), left.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        if (left.length() < right.length() || right.length() < left.length()) {
            return Integer.compare(left.length(), right.length());
        }
        for (int i = 2; i < length; i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
        }
        return result;
    }
}

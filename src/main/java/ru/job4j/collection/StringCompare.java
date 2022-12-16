package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = -1;
        char[] o1chars = o1.toCharArray();
        char[] o2chars = o2.toCharArray();
        int length = Math.min(o1chars.length, o2chars.length);
        for (int i = 0; i < length;) {
            result = Character.compare(o1chars[i], o2chars[i]);
            if (result == 0) {
                i++;
            } else {
                return result;
            }
        }
        if (o1chars.length < o2chars.length) {
            result = -1;
        } else if (o1chars.length > o2chars.length) {
            result = 1;
        }
        return result;
    }
}

package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] o1numToArray = o1.split(". ");
        String[] o2numToArray = o2.split(". ");
        int o1Num = Integer.parseInt(o1numToArray[0]);
        int o2Num = Integer.parseInt(o2numToArray[0]);
        return Integer.compare(o1Num, o2Num);
    }

}

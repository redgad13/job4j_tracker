package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class LexSort implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String[] o1numToArray = o1.toString().split(". ");
        String[] o2numToArray = o2.toString().split(". ");
        int o1Num = Integer.parseInt(o1numToArray[0]);
        int o2Num = Integer.parseInt(o2numToArray[0]);
        return Integer.compare(o1Num, o2Num);
    }

}

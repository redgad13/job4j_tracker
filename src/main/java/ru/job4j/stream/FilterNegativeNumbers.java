package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 423, -56, 90, 353, 457, 1, 2, 5, 3, 0, 6, 777);
        List<Integer> positive = numbers.stream().filter(num -> num > 0).toList();
        positive.forEach(System.out::println);
    }
}

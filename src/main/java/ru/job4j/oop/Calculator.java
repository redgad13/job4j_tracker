package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return x / y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        int result = sum(2);
        System.out.println(result);
        result = minus(2);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.divide(2);
        System.out.println(result);
        result = calculator.sumAllOperation(2);
        System.out.println(result);
    }
}

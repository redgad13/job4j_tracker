package ru.job4j.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String shop : shops) {
            if (shop != null) {
                String el = shop;
                if (el.length() > max) {
                    max = el.length();
                }
            }
        }
        System.out.println("Max length : " + max);
    }
}

package ru.job4j.oop;

public class Student {
    public static void main(String[] args) {
        Student petya = new Student();
        for (int i = 0; i < 3; i++) {
            petya.music();
        }

        for (int i = 0; i < 3; i++) {
            petya.song();
        }
    }

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }
}

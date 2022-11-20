package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        Student petr = new Student();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ivan.setFullName("Ivan Ivanov");
        ivan.setGroup(111);
        ivan.setEnter(LocalDateTime.of(2015, 4, 13, 15, 20));
        petr.setFullName("Petr Petrov");
        petr.setGroup(112);
        petr.setEnter(LocalDateTime.of(2015, 5, 1, 16, 40));
        System.out.println("Student " + ivan.getFullName() + " entered group # "
                + ivan.getGroup() + " on " + ivan.getEnter().format(formatter));
        System.out.println("Student " + petr.getFullName() + " entered group # "
                + petr.getGroup() + " on " + petr.getEnter().format(formatter));

    }
}

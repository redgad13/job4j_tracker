package ru.job4j.queue;

import java.util.Comparator;

public class TaskByPositionAsc implements Comparator<Position> {

    @Override
    public int compare(Position left, Position right) {
        return left.compareTo(right);
    }

    public Comparator<Task> thenComparing(TaskByUrgencyDesc taskByUrgencyDesc) {
        return taskByUrgencyDesc;
    }
}

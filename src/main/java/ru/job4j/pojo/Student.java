package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String fullName;
    private int group;
    private LocalDateTime enter;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDateTime getEnter() {
        return enter;
    }

    public void setEnter(LocalDateTime enter) {
        this.enter = enter;
    }
}

package ru.job4j.pojo;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setCode("xx123X178");
        license.setModel("Polo");
        license.setOwner("Vadim Kuzin");
        license.setCreated(new Date());
        System.out.println(license.getOwner() + " has a car " + license.getModel()
        + " " + license.getCode());

    }
}

package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс хранит данные о пользователе
 * Используется для работы с Классом БанкСервис @see ru.job4j.bank.BankService
 * @author Vadim Kuzin
 * @version 1.0
 */
public class User {
    /**
     * Номер паспорта хранится в типе String
     * Имя пользователя хранятся в типе String
     */
    private String passport;
    private String username;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param passport номер паспорта пользователя
     * @param username Имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Функция получения номера паспорта
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Функция для задания номера паспорта
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Функция получения имени пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Функция для задания имени пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

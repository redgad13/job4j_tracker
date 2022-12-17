package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет клиента
 * Используется для работы с Классом БанкСервис @see ru.job4j.bank.BankService
 *
 * @author Vadim Kuzin
 * @version 1.0
 */
public class Account {
    /**
     * В типе String хранятся реквизиты счета
     * В типе double хранятся данные о сумме на счету
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param requisite реквизиты счета
     * @param balance   данные о сумме на счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Функция получения реквизитов
     *
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * функция установки реквизитов
     *
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Функция получения суммы на счету
     *
     * @return сумма на счету
     */
    public double getBalance() {
        return balance;
    }

    /**
     * функция установки суммы на счету
     *
     * @param balance сумма на счету
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}

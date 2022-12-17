package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для работы с пользователями и с их счетами
 * Класс позволяет работать с пользователями: добавлять, удалять, искать по номеру паспорта
 * Класс позволяет работать со счетами: добавлять счет пользователю по номеру паспорта пользователя,
 * искать счет по реквизитам счета, переводить деньги со счета на счет по номеру паспорта отправителя
 * и получателя и реквизитам счетов отправителя и получателя
 *
 */
public class BankService {
    /**
     * Данные о всех пользователях и их счетах хранятся в HashMap
     * Ключ - пользователь, значения - все счета пользователя, хранящиеся в ArrayList
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Функция добавления нового пользователя в HashMap с пустым списком счетов
     * @param user данные добавляемого пользователя @see ru.job4j.bank.User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Функция уделения пользователя по номеру паспорта
     * @param passport номер паспорта пользователя @see ru.job4j.bank.User
     * @return
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Функция добавления счета пользователю по номеру его паспорта
     * Данные паспорта передаются в метод findByPassport()
     * @param passport номер паспорта пользователя @see ru.job4j.bank.User
     * @param account данные о счете пользователя @see ru.job4j.bank.Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return Объект класса User @see ru.job4j.bank.User
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                user = u;
                break;
            }
        }
        return user;
    }

    /**
     * Метод ищет счет по номеру паспорта пользователя и реквизитам счета
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает объект типа Account @see ru.job4j.bank.Account
     */
    public Account findByRequisite(String passport, String requisite) {
        Account desiredAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account a : users.get(user)) {
                if (requisite.equals(a.getRequisite())) {
                    desiredAccount = a;
                    break;
                }
            }
        }
        return desiredAccount;
    }

    /**
     * Функция перевода средств со одного счета на другой
     * Возможен перевод между счетами разных пользователей
     * @param srcPassport данные паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport данные паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return возвращает true/false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source == null || dest == null || source.getBalance() < amount) {
            return false;
        }
        dest.setBalance(dest.getBalance() + amount);
        source.setBalance(source.getBalance() - amount);
        return true;

    }

    /**
     * возвращает список всех счетов пользователя типа ArrayList
     * @param user объект класа типа User @see ru.job4j.bank.User
     * @return возвращает список счетов пользователя в формате ArrayList
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

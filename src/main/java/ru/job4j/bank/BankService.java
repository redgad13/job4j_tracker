package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public boolean deleteUser(String passport) {
        boolean isDeleted = false;
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                users.remove(u);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);

        }
    }

    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                return u;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = new ArrayList<>();
        Account desiredAccount = null;
        if (user != null) {
            accounts = users.get(user).stream().toList();
        }
        for (Account a : accounts) {
            if (requisite.equals(a.getRequisite())) {
                desiredAccount = a;
            }
        }
        return desiredAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account initialAccount = findByRequisite(srcPassport, srcRequisite);
        Account destinationAccount = findByRequisite(destPassport, destRequisite);
        if (initialAccount == null || destinationAccount == null) {
            return false;
        }
        if (initialAccount.getBalance() < amount) {
            return rsl;
        } else {
            double destAccountBalance = destinationAccount.getBalance() + amount;
            destinationAccount.setBalance(destAccountBalance);
            initialAccount.setBalance(initialAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
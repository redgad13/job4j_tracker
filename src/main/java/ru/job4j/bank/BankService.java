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
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source == null || dest == null || source.getBalance() < amount) {
            return false;
        } else {
            dest.setBalance(dest.getBalance() + amount);
            source.setBalance(source.getBalance() - amount);
            return true;
        }
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

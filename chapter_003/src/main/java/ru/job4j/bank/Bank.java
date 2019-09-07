package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> map = new TreeMap<>();

    public Set<User> getAllUsers() {
        return map.keySet();
    }

    public void addUser(User user) {
        this.map.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.map.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (!getUserAccounts(passport).contains(account)) {
            getUserAccounts(passport).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }

    public List<Account> getUserAccounts (String passport) {
        return this.map.get(new User("tmp", passport));
    }

    public boolean transferMoney(String srcPassport, String srcReq, String destPassport, String destReq, double among) {
        boolean result = false;
        List<Account> list1 = getUserAccounts(srcPassport);
        List<Account> list2 = getUserAccounts(destPassport);
        Account account1 = null;
        Account account2 = null;
        for (Account x : list1) {
            if (x.getRequisites().equals(srcReq)) {
                account1 = x;
            }
        }
        for (Account x : list2) {
            if (x.getRequisites().equals(destReq)) {
                account2 = x;
            }
        }
        if (account1 != null && account2 != null && account1.getValue() >= among) {
            account1.setValue(account1.getValue() - among);
            account2.setValue(account2.getValue() + among);
            result = true;
        }
        return result;
    }
}

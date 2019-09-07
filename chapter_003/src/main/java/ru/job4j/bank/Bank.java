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

    public User findUser(String passport) {
        User user = null;
        for (User x : map.keySet()) {
            if (passport.equals(x.getPassport())) {
                user = x;
            }
        }
        return user;
    }

    public void addAccountToUser(String passport, Account account) {
        if (!map.get(findUser(passport)).contains(account)) {
            map.get(findUser(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        map.get(findUser(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return map.get(findUser(passport));
    }

    public boolean transferMoney(String srcPassport, String srcReq, String destPassport, String destReq, double among) {
        boolean result = false;
        List<Account> list1 = getUserAccounts(srcPassport);
        List<Account> list2 = getUserAccounts(destPassport);
        for (Account x : list1) {
            if (x.getRequisites().equals(srcReq) && x.getValue() >= among) {
                x.setValue(x.getValue() - among);
                result = true;
            }
        }
        for (Account x : list2) {
            if (x.getRequisites().equals(destReq)) {
                x.setValue(x.getValue() + among);
            }
        }
        return result;
    }
}

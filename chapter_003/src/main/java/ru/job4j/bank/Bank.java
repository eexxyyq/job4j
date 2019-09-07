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
                break;
            }
        }
        return user;
    }

    public Account findAccByReqAndPassport(String passport, String req) {
        List<Account> tpm = getUserAccounts(passport);
        Account account = null;
        for (Account x : tpm) {
            if (req.equals(x.getRequisites())) {
                account = x;
                break;
            }
        }
        return account;
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
        Account account = findAccByReqAndPassport(srcPassport, srcReq);
        Account account1 = findAccByReqAndPassport(destPassport, destReq);
        if (account != null && account1 != null && account.getValue() >= among) {
            account.setValue(account.getValue() - among);
            account1.setValue(account1.getValue() + among);
            result = true;
        }
        return result;
    }
}

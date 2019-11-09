package ru.job4j.bank;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;

class Bank {
    private Map<User, List<Account>> map = new TreeMap<>();

    Set<User> getAllUsers() {
        return map.keySet();
    }

    void addUser(User user) {
        this.map.putIfAbsent(user, new ArrayList<>());
    }

    void deleteUser(User user) {
        this.map.remove(user);
    }

    private User findUser(String passport) {
        User user = null;
        for (User x : map.keySet()) {
            if (passport.equals(x.getPassport())) {
                user = x;
                break;
            }
        }
        return user;
    }

    private Account findAccByReqAndPassport(String passport, String req) {
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

    void addAccountToUser(String passport, Account account) {
        if (!map.get(findUser(passport)).contains(account)) {
            map.get(findUser(passport)).add(account);
        }
    }

    void deleteAccountFromUser(String passport, Account account) {
        map.get(findUser(passport)).remove(account);
    }

    List<Account> getUserAccounts(String passport) {
        return map.get(findUser(passport));
    }

    boolean transferMoney(String srcPassport, String srcReq, String destPassport, String destReq, double among) {
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

    boolean transferMoneyStreamAPI(String srcPassport, String srcReq, String destPassport, String destReq, double among) {
        boolean result = false;
        Account account1 = getUserAccounts(srcPassport).stream().filter(account -> account.getRequisites().equals(srcReq)).findFirst().get();
        Account account2 = getUserAccounts(destPassport).stream().filter(account -> account.getRequisites().equals(destReq)).findFirst().get();
        if (account1.getValue() >= among) {
            account1.setValue(account1.getValue() - among);
            account2.setValue(account2.getValue() + among);
            result = true;
        }
        return result;
    }
}

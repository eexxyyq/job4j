package ru.job4j.bank;

import java.util.*;

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
        return map.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    private Account findAccByReqAndPassport(String passport, String req) {
        return getUserAccounts(passport).stream()
                .filter(account -> account.getRequisites().equals(req))
                .findFirst().orElse(null);
    }

    void addAccountToUser(String passport, Account account) {
        User user = findUser(passport);
        if (!map.get(user).contains(account) && user != null) {
            map.get(user).add(account);
        }
    }

    void deleteAccountFromUser(String passport, Account account) {
        map.get(findUser(passport)).remove(account);
    }

    List<Account> getUserAccounts(String passport) {
        User user = findUser(passport);
        List<Account> listAccounts = new ArrayList<>();
        if (user != null) {
            listAccounts.addAll(map.get(user));
        }
        return listAccounts;
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
}

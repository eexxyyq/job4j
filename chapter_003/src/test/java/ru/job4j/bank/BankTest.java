package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    @Test
    public void whenWantToAddUser() {
        Bank bank = new Bank();
        User user = new User("asd", "123456");
        User user2 = new User("asd", "456");
        bank.addUser(user);
        bank.addUser(user2);
        Set<User> expect = new HashSet<>();
        expect.add(user);
        expect.add(user2);
        Set<User> result = bank.getAllUsers();
        assertThat(result, is(expect));
    }
    @Test
    public void whenWantToDeleteUser() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        User user2 = new User("456", "156321");
        User user3 = new User("asd", "788954");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        bank.deleteUser(user3);
        Set<User> expect = new HashSet<>();
        expect.add(user1);
        expect.add(user2);
        Set<User> result = bank.getAllUsers();
        assertThat(result, is(expect));
    }

    @Test
    public void whenWantToAddAccountsToUser() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        bank.addUser(user1);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user1.getPassport(), account2);
        List<Account> expect = new ArrayList<>();
        expect.add(account1);
        expect.add(account2);
        List<Account> result = bank.getUserAccounts(user1.getPassport());
        assertThat(result, is(expect));

    }

    @Test
    public void whenWantToDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        bank.addUser(user1);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user1.getPassport(), account2);
        bank.deleteAccountFromUser(user1.getPassport(), account2);
        List<Account> expect = new ArrayList<>();
        expect.add(account1);
        List<Account> result = bank.getUserAccounts(user1.getPassport());
        assertThat(result, is(expect));
    }

    @Test
    public void whenWantToTransferBetweenDifferentUsers() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        User user2 = new User("asd", "156321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        boolean result = bank.transferMoney(user1.getPassport(), account1.getRequisites(), user2.getPassport(), account2.getRequisites(), 234);
        assertThat(result, is(true));

    }

    @Test
    public void whenWantToTransferBetweenSameUsers() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        bank.addUser(user1);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user1.getPassport(), account2);
        boolean result = bank.transferMoney(user1.getPassport(), account1.getRequisites(), user1.getPassport(), account2.getRequisites(), 234);
        assertThat(result, is(true));

    }
    @Test
    public void whenWantToTransferBetweenDifferentUsersStreamAPI() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        User user2 = new User("asd", "156321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        boolean result = bank.transferMoneyStreamAPI(user1.getPassport(), account1.getRequisites(), user2.getPassport(), account2.getRequisites(), 234);
        assertThat(result, is(true));

    }

    @Test
    public void whenWantToTransferBetweenSameUsersStreamAPI() {
        Bank bank = new Bank();
        User user1 = new User("asd", "145");
        bank.addUser(user1);
        Account account1 = new Account(1234, "122334-123");
        Account account2 = new Account(1234, "122334-1234555");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user1.getPassport(), account2);
        boolean result = bank.transferMoneyStreamAPI(user1.getPassport(), account1.getRequisites(), user1.getPassport(), account2.getRequisites(), 234);
        assertThat(result, is(true));

    }

}

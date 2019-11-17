package ru.job4j.generic;

public class UserStore<User extends Base> extends AbstractStore<User> {
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}

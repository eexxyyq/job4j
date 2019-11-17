package ru.job4j.generic;

public class RoleStore<Role extends Base> extends AbstractStore<Role> {
    RoleStore(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }
}

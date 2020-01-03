package ru.job4j.post;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private Set<String> listOfEmails = new HashSet<>();

    public User(String name, String email) {
        this.name = name;
        this.listOfEmails.add(email);
    }

    public String getName() {
        return name;
    }

    public Set<String> getListOfEmails() {
        return listOfEmails;
    }

    public void addNewEmailFromSet(Set<String> list) {
        this.listOfEmails.addAll(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", listOfEmails=" + listOfEmails
                + '}';
    }

    public void addNewEmail(String email) {
        this.listOfEmails.add(email);
    }
}

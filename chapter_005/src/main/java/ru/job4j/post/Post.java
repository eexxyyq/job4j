package ru.job4j.post;

import java.util.*;

public class Post {
    private Set<User> base = new HashSet<>();

    public void addNewUser(User user) {
        this.base.add(user);
    }

    public Set<User> getBase() {
        return this.base;
    }

    public void rebase() {
        Set<String> emails = new HashSet<>();
        base.forEach(user -> emails.addAll(user.getListOfEmails()));
        for (String e : emails) {
            Set<User> tmpSet = new HashSet<>();
            for (User u : base) {
                if (u.getListOfEmails().contains(e)) {
                    tmpSet.add(u);
                }
            }
            if (tmpSet.size() > 1) {
                User mainUser = tmpSet.iterator().next();
                for (User user : tmpSet) {
                    mainUser.addNewEmailFromSet(user.getListOfEmails());
                    base.remove(user);
                    base.add(mainUser);
                }
            }
        }
    }
}

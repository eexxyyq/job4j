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
        HashMap<String, List<User>> map = new HashMap<>();
        Set<User> set = new HashSet<>();
        base.forEach(user -> {
            user.getListOfEmails().forEach(email -> {
                map.put(email, new ArrayList<>());
            });
        });
        map.keySet().forEach(email -> {
            base.forEach(user -> {
                if (user.getListOfEmails().contains(email)) {
                    map.get(email).add(user);
                }
            });
        });
        map.keySet().forEach(email -> {
            if (map.get(email).size() > 1) {
                for (int i = 1; i < map.get(email).size(); i++) {
                    map.get(email).get(0).addNewEmailFromSet(map.get(email).get(i).getListOfEmails());
                }
            }
            set.add(map.get(email).get(0));
        });
        this.base = set;
    }

}

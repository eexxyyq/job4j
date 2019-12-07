package ru.job4j.collection;

import java.util.List;
import java.util.Objects;

public class Analyze {
    public Info diff(List<User> previous, List<User> current) {
        int addedNewUsers = 0;
        int changedUsers = 0;
        int deletedUser = 0;
        int countRepeat = 0;
        for (User user : previous) {
            for (User user1 : current) {
                if ((user.getId() == user1.getId() && user.getName().equals(user1.getName())) ||
                        (user.getId() == user1.getId() && !user.getName().equals(user1.getName()))) {
                    countRepeat++;
                }
                if (user.getId() == user1.getId() && !user.getName().equals(user1.getName())) {
                    changedUsers++;
                }
            }
        }
        if (current.size() - countRepeat > 0) {
            addedNewUsers = current.size() - countRepeat;
        }
        if (previous.size() - countRepeat > 0) {
            deletedUser = previous.size() - countRepeat;
        }
        return new Info(addedNewUsers, changedUsers, deletedUser);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Info {
        int addedNewUsers;
        int changedUsers;
        int deletedUser;

        public Info(int addedNewUsers, int changedUsers, int deletedUser) {
            this.addedNewUsers = addedNewUsers;
            this.changedUsers = changedUsers;
            this.deletedUser = deletedUser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return addedNewUsers == info.addedNewUsers &&
                    changedUsers == info.changedUsers &&
                    deletedUser == info.deletedUser;
        }

        @Override
        public int hashCode() {
            return Objects.hash(addedNewUsers, changedUsers, deletedUser);
        }

        @Override
        public String toString() {
            return  "addedNewUsers = " + addedNewUsers
                    + "\n"
                    + "changedUsers = " + changedUsers
                    + "\n"
                    + "deletedUser = " + deletedUser;
        }
    }
}

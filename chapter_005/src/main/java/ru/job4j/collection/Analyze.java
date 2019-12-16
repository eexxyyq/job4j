package ru.job4j.collection;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyze {
    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, User> users = previous.stream().collect(Collectors.toMap(
                User::getId,
                Function.identity()
        ));
        current.forEach(user -> {
            User temp = users.remove(user.getId());
            if (temp == null) {
                result.addedNewUsers++;
            } else if (!temp.getName().equals(user.getName())) {
                result.changedUsers++;
            }
        });
        result.deletedUser = users.size();
        return result;
    }

    public static class User {
        private int id;
        private String name;

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

        @Override
        public String toString() {
            return "id = " + id
                    + "\n" + "name = " + name;
        }
    }

    public static class Info {
        int addedNewUsers;
        int changedUsers;
        int deletedUser;

        public Info() {
        }

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
            return addedNewUsers == info.addedNewUsers
                    && changedUsers == info.changedUsers
                    && deletedUser == info.deletedUser;
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

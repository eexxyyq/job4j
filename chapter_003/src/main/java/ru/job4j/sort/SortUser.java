package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result;
                if (o1.getName().equals(o2.getName())) {
                    result = Integer.compare(o1.getAge(), o2.getAge());
                } else {
                    result = 0;
                }
                return result;
            }
        });
        return list;
    }
}

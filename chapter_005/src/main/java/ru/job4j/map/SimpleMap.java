package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class SimpleMap {
    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User first = new User("Kotlin", 3, new GregorianCalendar(2013, Calendar.FEBRUARY, 20));
        User second = new User("Kotlin", 3, new GregorianCalendar(2013, Calendar.FEBRUARY, 20));
        map.put(first, first);
        map.put(second, second);
        System.out.println(map);
    }
}

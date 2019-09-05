package ru.job4j.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = Integer.compare(o1.length(), o2.length());
        int min = Math.min(o1.length(), o2.length());
        for (int i = 0; i < min; i++) {
            char first = o1.charAt(i);
            char second = o2.charAt(i);
            if (first != second) {
                result = Character.compare(first, second);
                break;
            }
        }
        return result;
    }
}

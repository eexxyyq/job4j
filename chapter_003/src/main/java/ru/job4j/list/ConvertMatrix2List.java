package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x : array) {
            for (int i = 0; i < x.length; i++) {
                list.add(x[i]);
            }
        }
        return list;
    }
}

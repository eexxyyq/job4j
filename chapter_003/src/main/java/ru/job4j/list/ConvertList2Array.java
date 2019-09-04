package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int arraySize = list.size();
        int cells = arraySize / rows;
        if (arraySize % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer x : list) {
            if (j == cells) {
                j = 0;
                i++;
            }
            array[i][j++] = x;
        }
        return array;
    }

    public List<Integer> covert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] x : list) {
            for (int i = 0; i < x.length; i++) {
                result.add(x[i]);
            }
        }
        return result;
    }
}

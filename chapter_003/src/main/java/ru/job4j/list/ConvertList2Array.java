package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int arraySize = list.size();
        int cells = arraySize / rows;
        int tmp = 0;

        if (arraySize % rows != 0) {
            cells++;
        }

        int[][] array = new int[rows][cells];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (tmp == list.size()) {
                    break;
                }
                array[i][j] = list.get(tmp++);
            }
        }
        return array;
    }
}

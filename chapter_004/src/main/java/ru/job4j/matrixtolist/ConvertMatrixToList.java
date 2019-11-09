package ru.job4j.matrixtolist;

import java.util.Arrays;
import java.util.List;

public class ConvertMatrixToList {
    public List<Integer> list(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).
    }
}

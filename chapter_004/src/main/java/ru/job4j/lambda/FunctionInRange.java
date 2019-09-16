package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInRange {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        int index = start;
        while (index < end) {
            result.add(func.apply((double) index));
            index++;
        }
        return result;
    }
}

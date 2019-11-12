package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Count {
    public double count(List<Integer> data) {
        double result = 0;
        Optional<Double> sum = data.stream().filter(x -> x % 2 == 0).map(x -> Math.pow(x, 2)).reduce(Double::sum);
        if(sum.isPresent()){
            result = sum.get();
        }
        return result;
    }
}

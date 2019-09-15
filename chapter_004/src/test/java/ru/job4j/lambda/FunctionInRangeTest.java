package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class FunctionInRangeTest {
    private FunctionInRange function = new FunctionInRange();
    @Test
    public void whenLinearFunction() {
        List<Double> result = function.diapason(5,8, (x) -> x*2);
        List<Double> expect = new ArrayList<>(Arrays.asList(10D, 12D, 14D));
        assertThat(result, is(expect));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = function.diapason(5,8, (x) -> x*x);
        List<Double> expect = new ArrayList<>(Arrays.asList(25D, 36D, 49D));
        assertThat(result, is(expect));
    }

    @Test
    public void whenLogFunction() {
        List<Double> result = function.diapason(5,8, Math::log);
        List<Double> expect = new ArrayList<>(Arrays.asList(1.6D, 1.8D, 1.94D));
        for (Double x : result) {
            assertThat(x, closeTo(expect.get(result.indexOf(x)), 0.1));
        }
    }
}

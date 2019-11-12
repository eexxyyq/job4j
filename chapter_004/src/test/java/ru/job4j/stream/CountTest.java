package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountTest {
    @Test
    public void whenWantToCountCollections() {
        Count count = new Count();
        double result = count.count(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        double expect = 120D;
        assertThat(result, is(expect));
    }
}

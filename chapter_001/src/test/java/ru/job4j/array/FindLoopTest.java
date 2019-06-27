package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на поиск перебором
 */
public class FindLoopTest {
    @Test
    public void whenElIs5ThenIndexIs0() {
        FindLoop fl = new FindLoop();
        int[] input = new int[] {5, 7, 9};
        int value = 5;
        int result = fl.indexOf(input, value);
        int expected = 0;
        assertThat(result, is(expected));
    }
    @Test
    public void whenElIs7ThenIndexIsMinus1() {
        FindLoop fl = new FindLoop();
        int[] input = new int[] {5, 7, 9};
        int value = 6;
        int result = fl.indexOf(input, value);
        int expected = -1;
        assertThat(result, is(expected));
    }
}

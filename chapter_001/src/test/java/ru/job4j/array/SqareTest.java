package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест заполнения массива квадратами чисел
 */
public class SqareTest {
    @Test
    public void whenBoundsAre3Then149() {
        Square sq = new Square();
        int[] result = sq.calculate(3);
        int[] expected = new int[] {1, 4, 9};
        assertThat(result, is(expected));
    }
    @Test
    public void whenBoundsAre6Then149162536() {
        Square sq = new Square();
        int[] result = sq.calculate(6);
        int[] expected = new int[] {1, 4, 9, 16, 25, 36};
        assertThat(result, is(expected));
    }
    @Test
    public void whenBoudsAre3ThenLengthAre3() {
        Square sq = new Square();
        int[] result = sq.calculate(3);
        int[] expected = new int[3];
        assertThat(result.length, is(expected.length));
    }
}

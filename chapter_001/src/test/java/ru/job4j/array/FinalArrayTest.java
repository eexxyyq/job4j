package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для массивов одного размера и разных размеров
 */
public class FinalArrayTest {
    @Test
    public void when2ArrayThen1SortedArray() {
        FinalArray fin = new FinalArray();
        int[] input1 = new int[] {1, 10, 10};
        int[] input2 = new int[] {2, 3, 4, 8};
        int[] result = fin.merge(input1, input2);
        int[] expected = {1, 2, 3, 4, 8, 10, 10};
        assertThat(result, is(expected));
    }

    @Test
    public void when2OneSizeArrayThen1SortedArray() {
        FinalArray fin = new FinalArray();
        int[] input1 = new int[] {1, 10};
        int[] input2 = new int[] {4, 8};
        int[] result = fin.merge(input1, input2);
        int[] expected = {1, 4, 8, 10};
        assertThat(result, is(expected));
    }

    @Test
    public void whenFirstArrayIsEmpty() {
        FinalArray fin = new FinalArray();
        int[] input1 = new int[0];
        int[] input2 = new int[] {4, 8};
        int[] result = fin.merge(input1, input2);
        int[] expected = {4, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSecondArrayIsEmpty() {
        FinalArray fin = new FinalArray();
        int[] input1 = new int[] {4, 8};
        int[] input2 = new int[0];
        int[] result = fin.merge(input1, input2);
        int[] expected = {4, 8};
        assertThat(result, is(expected));
    }
}

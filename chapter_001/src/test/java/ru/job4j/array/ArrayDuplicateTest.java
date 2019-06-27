package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] input = new String[] {"Hello", "Hi", "Good Morning", "Hi"};
        String[] expected = new String[] {"Hello", "Hi", "Good Morning"};
        String[] result = ad.remove(input);
        assertThat(result, is(expected));

    }
}
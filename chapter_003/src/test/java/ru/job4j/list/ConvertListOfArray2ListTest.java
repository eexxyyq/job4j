package ru.job4j.list;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertListOfArray2ListTest {
    @Test
    public void whenThree3n2ArraysThenList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> input = Arrays.asList(new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6});
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = list.covert(input);
        assertThat(result, is(expect));
    }
}

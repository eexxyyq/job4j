package ru.job4j.matrixtolist;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixToListTest {
    @Test
    public void whenWantConvertMatrixArrayToList() {
        ConvertMatrixToList cm = new ConvertMatrixToList();
        Integer[][] input = {{1, 2}, {4, 6}, {8, 9}};
        List<Integer> result = cm.list(input);
        List<Integer> expect = List.of(1, 2, 4, 6, 8, 9);
        assertThat(result, is(expect));

    }

}

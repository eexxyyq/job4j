package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax2To1Then2() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax2To2Then2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2To3Then3() {
        Max max = new Max();
        int result = max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax1To5To3Then5() {
        Max max = new Max();
        int result = max.max(1, 5, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax7To2To3Then7() {
        Max max = new Max();
        int result = max.max(7, 2, 3);
        assertThat(result, is(7));
    }

    @Test
    public void whenMax1To2To3To4Then4() {
        Max max = new Max();
        int result = max.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax7To2To3To4Then7() {
        Max max = new Max();
        int result = max.max(7, 2, 3, 4);
        assertThat(result, is(7));
    }

    @Test
    public void whenMax1To6To3To4Then6() {
        Max max = new Max();
        int result = max.max(1, 6, 3, 4);
        assertThat(result, is(6));
    }

    @Test
    public void whenMax1To2To9To4Then9() {
        Max max = new Max();
        int result = max.max(1, 2, 9, 4);
        assertThat(result, is(9));
    }

    @Test
    public void whenMax1To1To1To1Then1() {
        Max max = new Max();
        int result = max.max(1, 1, 1, 1);
        assertThat(result, is(1));
    }

}
package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;
    @Before
    public void init() {
        simpleArray = new SimpleArray<>(5);
    }
    @Test
    public void whenAddAnThreeObject() {
        simpleArray.add(123);
        simpleArray.add(567);
        simpleArray.add(765);
        assertThat(simpleArray.get(1), is(567));
    }

    @Test
    public void whenRemoveAnObject() {
        simpleArray.add(123);
        simpleArray.add(567);
        simpleArray.add(765);
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is(567));
    }

    @Test
    public void whenSetAnObject() {
        simpleArray.add(123);
        simpleArray.add(567);
        simpleArray.add(765);
        simpleArray.set(0, 98);
        assertThat(simpleArray.get(0), is(98));
    }

}

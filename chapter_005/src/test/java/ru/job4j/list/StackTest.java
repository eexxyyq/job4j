package ru.job4j.list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StackTest {
    @Test
    public void whenWantToPoll() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.poll();
        simpleStack.poll();
        assertThat(simpleStack.poll(), is(1));
    }
}

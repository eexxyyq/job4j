package ru.job4j.list;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {
    @Test
    public void whenWantToTestQueue() {
        SimpleQueue<Integer> sq = new SimpleQueue<>();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.poll();
        assertThat(sq.poll(), is(2));
    }
}

package ru.job4j.list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class NodeTest {
    @Test
    public void whenWantToTestNodeCycle() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = first;
        third.next = four;
        four.next = first;
        boolean res = first.hasCycle(two);
        assertThat(res, is(true));
    }
}

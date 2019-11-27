package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SomeLinkedContainer<E> implements Iterable<E> {
    private int size;
    private Node<E> node;
    private int modCount = 0;

    void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.node;
        this.node = newLink;
        size++;
        modCount++;
    }

    E get(int index) {
        Node<E> res = this.node;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node (E data) {this.data = data;}
    }

    void deleteFirst() {
        this.node = this.node.next;
        size--;
    }

    int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int indexIter = 0;
            private int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return indexIter < size;
            }

            @Override
            public E next() {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                indexIter++;
                return (E) node.next;
            }
        };
    }
}

package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SomeContainer<E> implements Iterable<E> {
    private Object[] container = new Object[10];
    private int index = 0;
    private int countMod = 0;

    private void getNewSize() {
        if (index == this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
            countMod++;
        }
    }

    public void add(E model) {
        getNewSize();
        this.container[index++] = model;
        countMod++;
    }

    public E get(int index) {
        E result = null;
        if (this.container[index] != null) {
            result = (E) this.container[index];
        }
        return result;
    }

    public int getSize() {
        return this.index;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            int indexIter = 0;
            int checkMod = countMod;
            @Override
            public boolean hasNext() {
                return indexIter < container.length;
            }

            @Override
            public Object next() {
                if (checkMod != countMod) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(indexIter++);
            }
        };
    }
}

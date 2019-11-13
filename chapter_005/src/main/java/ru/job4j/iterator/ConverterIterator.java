package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConverterIterator {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                if (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}

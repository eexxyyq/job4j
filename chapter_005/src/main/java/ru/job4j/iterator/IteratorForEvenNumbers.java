package ru.job4j.iterator;

import java.util.*;
import java.util.stream.Collectors;

public class IteratorForEvenNumbers implements Iterator {
    private final int[] array;

    public IteratorForEvenNumbers(final int[] array) {
        this.array = array;
    }

    private int x;

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (x < array.length) {
            if (array[x] % 2 == 0) {
                result = true;
                break;
            } else {
                x++;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[x++];
    }
}

package ru.job4j.iterator;

import java.util.Iterator;

public class IteratorArray implements Iterator<Integer> {
    private final int[][] array;
    private int countFirst = 0;
    private int countSecond = 0;

    IteratorArray(final int[][] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return countSecond < array[countFirst].length;
    }

    @Override
    public Integer next() {
        int result = array[countFirst][countSecond++];
        if (countSecond == array[countFirst].length && countFirst < array.length - 1) {
            countSecond = 0;
            countFirst++;
        }
        return result;
    }

}

package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable {
    private Object[] arr;
    private int index = 0;

    SimpleArray() {
        this.arr = new Object[10];
    }
    private void checkArray() {
        if (index == this.arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
    }

    void add(T model) {
        checkArray();
        if (index == arr.length) {
            System.out.println("Array is fully");
        } else {
            this.arr[index++] = model;
        }
    }

    void set(int pos, T model) {
        if (this.arr[pos] != null) {
            this.arr[pos] = model;
        }
    }

    void remove(int index) {
        if (this.arr.length - 1 - index >= 0) {
            System.arraycopy(this.arr, index + 1, this.arr, index, this.arr.length - 1 - index);
        }
        this.arr[this.arr.length - 1] = null;
        this.index--;
    }

    Object get(int index) {
        return this.arr[index];
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (count < index) {
                    result = true;
                }
                return result;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arr[count++];
            }
        };
    }
}

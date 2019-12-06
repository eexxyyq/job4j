package ru.job4j.map;

import java.util.*;

public class Bucket<K, V> {
    private int size = 0;
    private int defaultSize = 16;

    @SuppressWarnings("unchecked")
    private Pair<K, V>[] values = new Pair[defaultSize];

    private void checkSize() {
        if (size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    private void makeSolidBucket(int start) {
        if (size - start >= 0) {
            System.arraycopy(values, start + 1, values, start, size - start);
        }
    }

    public V get(K key) {
        V result = null;
        for (Pair<K, V> b : values) {
            if (b != null) {
                if (b.getKey().equals(key)) {
                    result = b.getValue();
                }
            }
        }
        return result;
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        boolean newData = true;
        if (key != null) {
            for (Pair<K, V> b : values) {
                if (b != null) {
                    if (b.getKey().equals(key)) {
                        b.setValue(value);
                        newData = false;
                        result = true;
                        break;
                    }
                }
            }
            if (newData) {
                checkSize();
                values[size++] = new Pair<>(key, value);
                result = true;
            }
        }

        return result;
    }

    public List<Pair<K, V>> getAllPairs() {
        List<Pair<K, V>> list = new ArrayList<>();
        for (Pair<K, V> p : values) {
            if (p != null) {
                list.add(p);
            }
        }
        return list;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (key != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null) {
                    if (values[i].getKey().equals(key)) {
                        values[i] = null;
                        size--;
                        result = true;
                        makeSolidBucket(i);
                        break;
                    }
                }
            }
        }
        return result;
    }
}

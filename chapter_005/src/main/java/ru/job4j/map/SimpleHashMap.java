package ru.job4j.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<Pair<K, V>> {
    private int bucketValue = 0;
    @SuppressWarnings("unchecked")
    private Bucket<K, V>[] map = new Bucket[16];

    private int hashFunc(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % 16);
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        if (map[hashFunc(key)] == null) {
            map[hashFunc(key)] = new Bucket<>();
        }
        if (key != null) {
            map[hashFunc(key)].insert(key, value);
            result = true;
        }
        return result;
    }

    public boolean delete(K key) {
       return map[hashFunc(key)].delete(key);
    }

    public V get(K key) {
        return map[hashFunc(key)].get(key);
    }

    public List<Pair<K, V>> getAllPair() {
        List<Pair<K, V>> result = new ArrayList<>();
        for (Bucket<K, V> b : map) {
            if (b != null) {
                result.addAll(b.getAllPairs());
            }
        }
        return result;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<>() {
            int indexIter = 0;

            @Override
            public boolean hasNext() {
                return indexIter < getAllPair().size();
            }

            @Override
            public Pair<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return getAllPair().get(indexIter++);
            }
        };
    }
}

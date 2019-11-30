package ru.job4j.set;

import ru.job4j.list.SomeContainer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    private SomeContainer<T> set = new SomeContainer<>();
    private int index = 0;
    private boolean checkRepeat(T model) {
        boolean result = false;
        for (int i = 0; i < set.getSize(); i++) {
            if (model.equals(set.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int getSize() {
        return set.getSize();
    }

    public void add(T model) {
        if (!checkRepeat(model)) {
            set.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

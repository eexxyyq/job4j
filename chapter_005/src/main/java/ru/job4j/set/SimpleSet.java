package ru.job4j.set;

import ru.job4j.list.SomeContainer;

public class SimpleSet<T> extends SomeContainer<T> {
    @Override
    public void add(T model) {
        int count = 0;
        for (int i = 0; i < super.getSize(); i++) {
            if (model == super.get(i) ) {
                count++;
            }
        }
        if (count == 0) {
            super.add(model);
        }
    }
}

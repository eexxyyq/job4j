package ru.job4j.generic;

import java.util.Iterator;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int count = 0;
        boolean result = false;
        for (Iterator<T> it = simpleArray.iterator(); it.hasNext(); ) {
            count++;
            if (it.next().getId().equals(id)) {
                simpleArray.set(count, model);
                result = true;
                break;
            }

        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int pos = Integer.parseInt(id);
        boolean result = false;
        if (simpleArray.get(pos) != null) {
            simpleArray.remove(pos);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int pos = Integer.parseInt(id);
        return (T) simpleArray.get(pos);
    }
}

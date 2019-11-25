package ru.job4j.generic;


public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }
    private int getIndex(String id) {
        int index = -1;
        int count = 0;
        for (T x: (Iterable<T>) simpleArray) {
            count++;
            if (x.getId().equals(id)) {
                index = count;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T res = null;
        int index = getIndex(id);
        if (index != -1) {
            res = (T) simpleArray.get(index);
        }
        return res;
    }
}

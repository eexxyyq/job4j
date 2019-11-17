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

    @Override
    public boolean replace(String id, T model) {
        int pos = Integer.parseInt(id);
        boolean result = false;
        if (simpleArray.get(pos) != null) {
            simpleArray.set(pos, model);
            result = true;
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

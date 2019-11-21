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
        int count = 0;
        boolean result = false;
        for (T o : (Iterable<T>) simpleArray) {
            count++;
            if (o.getId().equals(id)) {
                simpleArray.set(count, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int count = 0;
        boolean result = false;
        for (T o : (Iterable<T>) simpleArray) {
            count++;
            if (o.getId().equals(id)) {
                simpleArray.remove(count);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T res = null;
        int count = 0;
        for (T o : (Iterable<T>) simpleArray) {
            count++;
            if (o.getId().equals(id)) {
                res = (T) simpleArray.get(count);
                break;
            }
        }
        return res;
    }
}

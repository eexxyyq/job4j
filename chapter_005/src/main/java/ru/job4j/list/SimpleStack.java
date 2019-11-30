package ru.job4j.list;

public class SimpleStack<T> {
    private SomeLinkedContainer<T> list = new SomeLinkedContainer<T>();

    void push(T data) {
        list.add(data);
    }

    T poll() {
        T result = list.get(0);
        list.deleteFirst();
        return result;
    }

    int getSize() {
        return list.getSize();
    }

    boolean isEmpty() {
        return getSize() == 0;
    }
}

package ru.job4j.list;

public class SimpleStack<T> {
    private SomeLinkedContainer<T> list = new SomeLinkedContainer<T>();

    void push(T data) {
        list.add(data);
    }

    T poll() {
        T result = list.get(list.getSize() - 1);
        list.deleteForStack();
        return result;
    }
}

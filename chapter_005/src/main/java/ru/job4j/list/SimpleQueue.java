package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> first = new SimpleStack<T>();
    private SimpleStack<T> second = new SimpleStack<T>();


    public void push(T data) {
        first.push(data);
    }

    /**
     * Метод удаляет жлемент из второго контейнера, добавляет в него элемент из первого, если он имеется
     * и возвращает удаленный элемент
     * @return
     */
    public T poll() {
        if (second.isEmpty()) {
            while(!first.isEmpty()) {
                second.push(first.poll());
            }
        }
        return second.poll();
    }
}

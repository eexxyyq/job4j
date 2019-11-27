package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> first = new SimpleStack<T>();
    private SimpleStack<T> second = new SimpleStack<T>();

    /**
     * Метод проверяет заполнен ли второй стек,
     * если нет - то добавляет новый элемент в него, если полон - то в первый
     * @param data
     */
    public void push(T data) {
        if (second.getSize() < 10) {
            second.push(data);
        } else {
            first.push(data);
        }
    }

    /**
     * Метод удаляет жлемент из второго контейнера, добавляет в него элемент из первого, если он имеется
     * и возвращает удаленный элемент
     * @return
     */
    public T poll() {
        T result = second.poll();
        if (!first.isEmpty()) {
            second.push(first.poll());
        }
        return result;
    }
}

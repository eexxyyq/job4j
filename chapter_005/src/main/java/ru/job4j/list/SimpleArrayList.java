package ru.job4j.list;

class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    boolean delete() {
        boolean result = false;
        if (this.first != null) {
            this.first = this.first.next;
            this.size--;
            result = true;
        }
        return result;
    }

    E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    int getSize() {
        return this.size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
        }
    }
}

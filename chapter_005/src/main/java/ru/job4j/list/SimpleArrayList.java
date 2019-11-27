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
    E delete() {
        E result = null;
        if (this.first != null) {
            result = (E) this.first;
            this.first = this.first.next;
            this.size--;
        }
        if (result == null) {
            throw new IllegalArgumentException();
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

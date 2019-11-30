package ru.job4j.list;

public class Node<T> {
    private T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node one = first;
        Node two = first;
        while (two != null || two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one == two) {
                result = true;
                break;
            }
        }
        return result;
    }
}

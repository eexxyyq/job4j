package ru.job4j.tree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> node;
    private int modCount;

    public Tree(E value) {
        this.node = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (this.findBy(parent).isPresent()) {
            this.findBy(parent).ifPresent(
                    eNode -> node.add(new Node<>(child))
            );
            result = true;
            this.modCount++;

        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> first = Optional.empty();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.node);
        while (!queue.isEmpty()) {
            Node<E> el = queue.poll();
            if (el.eqValue(value)) {
                first = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                queue.offer(child);
            }
        }
        return first;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return node.leaves().iterator().hasNext();
            }

            @Override
            public E next() {
                return node.leaves().iterator().next();
            }
        };
    }
}

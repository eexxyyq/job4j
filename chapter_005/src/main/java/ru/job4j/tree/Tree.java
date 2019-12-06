package ru.job4j.tree;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> node;

    public Tree(E value) {
        this.node = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> checkRepeat = findBy(parent);
        if (checkRepeat.isPresent()) {
            Node<E> parentEl = checkRepeat.get();
            boolean repeat = false;
            for (Node<E> node : parentEl.leaves()) {
                if (node.eqValue(child)) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                parentEl.add(new Node<>(child));
                result = true;
            }
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
        return new Iterator<>() {
            Queue<Node<E>> elements = new LinkedList<>(Collections.singletonList(node));

            @Override
            public boolean hasNext() {
                return elements.iterator().hasNext();
            }

            @Override
            public E next() {
                Node<E> res = this.elements.poll();
                assert res != null;
                elements.addAll(res.leaves());
                return res.getValue();
            }
        };
    }
}

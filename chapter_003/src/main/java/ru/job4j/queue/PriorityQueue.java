package ru.job4j.queue;

import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    void put(Task task) {
        int count = tasks.size();
        for (Task x : tasks) {
            if (task.getPriority() < x.getPriority()) {
                count = tasks.indexOf(x);
            }
        }
        tasks.add(count, task);
    }

    Task take() {
        return this.tasks.poll();
    }

}

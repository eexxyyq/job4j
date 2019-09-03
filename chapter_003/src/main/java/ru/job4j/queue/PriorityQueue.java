package ru.job4j.queue;

import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    void put(Task task) {
        int count = tasks.size();
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                count = i;
                break;
            }
        }
        tasks.add(count, task);
    }

    Task take() {
        return this.tasks.poll();
    }

}

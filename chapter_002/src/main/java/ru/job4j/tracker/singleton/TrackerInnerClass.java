package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerInnerClass {
    private Tracker tracker = new Tracker();
    private TrackerInnerClass() {
    }
     static TrackerInnerClass getInstance() {
        return Holder.INSTANCE;
     }

    private static final class Holder {
        private static final TrackerInnerClass INSTANCE = new TrackerInnerClass();
    }

    public static void main(String[] args) {
        TrackerInnerClass tracker = TrackerInnerClass.getInstance();
    }
}

package ru.job4j.tracker.singleton;


import ru.job4j.tracker.Tracker;

class TrackerStaticField {
    private Tracker tracker = new Tracker();
    private static TrackerStaticField instance;

    private TrackerStaticField() {
    }

    static TrackerStaticField getInstance() {
        if (instance == null) {
            instance = new TrackerStaticField();
        }
        return instance;
    }
}

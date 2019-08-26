package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

class TrackerStaticFinalField {
    private Tracker tracker = new Tracker();
    private static final TrackerStaticFinalField INSTANCE = new TrackerStaticFinalField();

    private TrackerStaticFinalField() {
    }

    static TrackerStaticFinalField getINSTANCE() {
        return INSTANCE;
    }


}

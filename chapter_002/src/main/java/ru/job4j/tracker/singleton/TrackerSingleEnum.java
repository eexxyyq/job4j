package ru.job4j.tracker.singleton;
import ru.job4j.tracker.Tracker;

public enum TrackerSingleEnum {
    INSTANCE;
    private Tracker tracker = new Tracker();
}

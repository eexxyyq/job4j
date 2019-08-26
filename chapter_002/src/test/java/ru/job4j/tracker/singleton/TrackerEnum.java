package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerEnum {
    @Test
    public void whenTwoTrackerEnumsAreEqual() {
        TrackerSingleEnum first = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum second = TrackerSingleEnum.INSTANCE;
        assertThat(first, is(second));
    }
}

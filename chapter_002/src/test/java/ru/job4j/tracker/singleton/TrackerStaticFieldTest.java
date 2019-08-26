package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerStaticFieldTest {
    @Test
    public void whenTwoTrackerAreEqual() {
        TrackerStaticField first = TrackerStaticField.getInstance();
        TrackerStaticField second = TrackerStaticField.getInstance();
        assertThat(first, is(second));
    }
}

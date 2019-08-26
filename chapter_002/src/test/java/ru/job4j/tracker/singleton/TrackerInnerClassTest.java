package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
public class TrackerInnerClassTest {
    @Test
    public void whenTwoTrackerThenTwoAreEqual() {
        TrackerInnerClass first = TrackerInnerClass.getInstance();
        TrackerInnerClass second = TrackerInnerClass.getInstance();
        assertThat(first, is(second));
    }
}

package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
public class TrackerStaticFinalFieldTest {
    @Test
    public void whenTwoTrackerThenBothAreEqual() {
        TrackerStaticFinalField first = TrackerStaticFinalField.getINSTANCE();
        TrackerStaticFinalField second = TrackerStaticFinalField.getINSTANCE();
        assertThat(first, is(second));
    }
}

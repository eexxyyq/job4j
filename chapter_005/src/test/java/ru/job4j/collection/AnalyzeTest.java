package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalyzeTest {

    @Test
    public void whenAnalyzeTwoCollections() {
        Analyze analyze = new Analyze();
        Analyze.User user1 = new Analyze.User(1, "asd");
        Analyze.User user2 = new Analyze.User(2, "bsd");
        Analyze.User user3 = new Analyze.User(3, "qwe");
        Analyze.User user4 = new Analyze.User(1, "jhg");
        Analyze.User user5 = new Analyze.User(5, "frt");
        Analyze.User user6 = new Analyze.User(6, "yhb");
        List<Analyze.User> previous = new ArrayList<>(List.of(user1, user2, user3)); 
        List<Analyze.User> current = new ArrayList<>(List.of(user4, user2, user5, user6));
        Analyze.Info expected = new Analyze.Info(2, 1, 1);
        Analyze.Info result = analyze.diff(previous, current);
        assertThat(result, is(expected));


    }
}

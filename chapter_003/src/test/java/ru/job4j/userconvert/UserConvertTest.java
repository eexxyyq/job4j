package ru.job4j.userconvert;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void whenListOfUsersThenMapOfIndexAndUsers() {
        UserConvert usr = new UserConvert();
        User john = new User(1, "John", "NY");
        User sarah = new User(2, "Sarah", "San-Francisco");
        User eliza = new User(3, "Eliza", "Toronto");
        List<User> input = Arrays.asList(john, sarah, eliza);
        Map<Integer, User> expect = Map.of(john.getId(), john, sarah.getId(), sarah, eliza.getId(), eliza);
        HashMap<Integer, User> result = usr.process(input);
        assertThat(result, is(expect));
    }
}

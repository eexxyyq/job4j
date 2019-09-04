package ru.job4j.userconvert;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(john.getId(), john);
        expect.put(sarah.getId(), sarah);
        expect.put(eliza.getId(), eliza);
        HashMap<Integer, User> result = usr.process(input);
        assertThat(result, is(expect));
    }
}

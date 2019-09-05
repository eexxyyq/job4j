package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void whenListThenTreeSet() {
        SortUser su = new SortUser();
        User user1 = new User("John", 6);
        User user2 = new User("Liza", 44);
        User user3 = new User("Petr", 66);
        User user4 = new User("Symon", 22);
        List<User> input = Arrays.asList(user1, user2, user3, user4);
        List<User> expect = (Arrays.asList(user1, user4, user2, user3));
        Set<User> result = su.sort(input);
        assertThat(result.toArray(), is(expect.toArray()));
    }

    @Test
    public void whenSortedByLength() {
        SortUser su = new SortUser();
        User user1 = new User("Joooohn Cena", 6);
        User user2 = new User("Liza", 44);
        User user3 = new User("Petruccho", 66);
        User user4 = new User("Sy", 22);
        List<User> input = Arrays.asList(user1, user2, user3, user4);
        List<User> expect = (Arrays.asList(user4, user2, user3, user1));
        List<User> result = su.sortNameLength(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortedByAllFields() {
        SortUser su = new SortUser();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        List<User> input = Arrays.asList(user1, user2, user3, user4);
        List<User> expect = (Arrays.asList(user4, user2, user3, user1));
        List<User> result = su.sortByAllFields(input);
        assertThat(result, is(expect));
    }

}

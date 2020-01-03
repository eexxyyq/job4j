package ru.job4j.post;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThat;
public class PostTest {
    @Test
    public void postTest() {
        Post post = new Post();
        User user1 = new User("user1", "email1");
        User user2 = new User("user2", "email2");
        User user3 = new User("user3", "email3");
        User user4 = new User("user4", "email4");
        user4.addNewEmail("email5");
        user4.addNewEmail("email1");
        user3.addNewEmail("email4");
        post.addNewUser(user1);
        post.addNewUser(user2);
        post.addNewUser(user3);
        post.addNewUser(user4);
        post.rebase();
        Set<User> expected = new HashSet<>();
        expected.add(user3);
        expected.add(user2);
        Set<User> result = post.getBase();
        assertThat(result, is(expected));
    }
}

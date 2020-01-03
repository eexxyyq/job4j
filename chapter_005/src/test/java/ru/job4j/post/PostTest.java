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
        User user1 = new User("user1", "xxx@ya.ru");
        User user2 = new User("user2", "foo@gmail.com");
        User user3 = new User("user3", "xyz@pisem.net");
        User user4 = new User("user4", "ups@pisem.net");
        User user5 = new User("user5", "xyz@pisem.net");
        user1.addNewEmail("foo@gmail.com");
        user1.addNewEmail("lol@mail.ru");
        user2.addNewEmail("ups@pisem.net");
        user3.addNewEmail("vasya@pupkin.com");
        user4.addNewEmail("aaa@bbb.ru");
        post.addNewUser(user1);
        post.addNewUser(user2);
        post.addNewUser(user3);
        post.addNewUser(user4);
        post.addNewUser(user5);
        post.rebase();
        Set<User> expected = new HashSet<>();
        expected.add(user2);
        expected.add(user3);
        Set<User> result = post.getBase();
        assertThat(result, is(expected));
    }
}

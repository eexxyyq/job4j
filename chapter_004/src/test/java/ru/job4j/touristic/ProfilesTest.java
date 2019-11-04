package ru.job4j.touristic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    private List<Profile> list() {
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            profiles.add(new Profile(new Address("city_" + i, "street_" + i, i, i)));
        }
        return profiles;
    }
    private List<Profile> list2() {
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            profiles.add(new Profile(new Address("city_0", "street_0", 0, 0)));
        }
        return profiles;
    }
    private List<Address> expected1() {
        List<Address> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            res.add(new Address("city_" + i, "street_" + i, i, i));
        }
        return res;
    }
    private List<Address> expected2() {
        List<Address> res = new ArrayList<>();
        res.add(new Address("city_0", "street_0", 0, 0));
        return res;
    }
    @Test
    public void whenWantToSomeAddress() {
        List<Profile> profiles = list();
        List<Address> res = Profiles.collect(profiles);
        assertThat(res, is(expected1()));
    }
    @Test
    public void whenWantToSomeUniqAddress() {
        List<Profile> profiles = list2();
        List<Address> res = Profiles.collect(profiles);
        assertThat(res, is(expected2()));
    }
}

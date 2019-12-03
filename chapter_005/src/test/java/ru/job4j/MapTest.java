package ru.job4j;
import org.junit.Test;
import ru.job4j.map.Pair;
import ru.job4j.map.SimpleHashMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MapTest {
    @Test
    public void whenWantToInsertSomething() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("first", 3);
        map.insert("second", 2);
        map.insert("first1", 1);
        map.insert("second1", 2);
        map.insert("first22", 1);
        map.insert("second3", 2);
        map.insert("first4", 1);
        map.insert("second6", 2);
        Integer result = map.get("first1");
        Integer expect = 1;
        for (Pair<String, Integer> p : map) {
            System.out.println(p);
        }
        assertThat(result, is(expect));
    }
    @Test
    public void whenWantToDeleteSomething() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.delete("first");
        Integer result = map.get("first");
        Integer expect = null;
        assertThat(result, is(expect));
    }
}

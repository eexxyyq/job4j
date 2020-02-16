package ru.job4j.io;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTest {
    @Test
    public void whenWantToFindXMLAndTxt() {
        Search search = new Search();
        List<String> list = new ArrayList<>();
        list.add("xml");
        list.add("txt");
        List<File> resultList = search.files("TempDir/", list);
        List<String> result = new ArrayList<>();
        for (File f : resultList) {
            result.add(f.getName());
        }
        List<String> expect = new ArrayList<>(List.of("test2.xml", "test1.txt", "test4.txt"));
        Collections.sort(result);
        Collections.sort(expect);
        assertThat(result, is(expect));
    }
}

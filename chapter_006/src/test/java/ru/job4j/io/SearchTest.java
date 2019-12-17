package ru.job4j.io;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchTest {
    @Test
    public void whenWantToFindXMLAndTxt() {
        Search search = new Search();
        List<String> list = new ArrayList<>();
        list.add("xml");
        list.add("txt");
        List<File> resultList = search.files("/Users/elizavetastrelkova/IdeaProjects/TempDir", list);
        List<String> result = new ArrayList<>();
        for (File f : resultList) {
            result.add(f.getName());
        }
        List<String> expect = new ArrayList<>(List.of("test.xml", "test.txt", "test4.txt"));
        assertThat(result, is(expect));
    }
}

package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalyzeTest {
    @Test
    public void analyzeTest() throws IOException {
        Analyze analyze = new Analyze();
        String source = "data/server.log";
        String target = "data/target.txt";
        analyze.unavailable(source, target);
        String expected = "10:57:01 - 10:59:01";
        String result;
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.readLine();
        }
        assertThat(result, is(expected));
    }
}

package ru.job4j.io;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigTest {
    @Test
    public void configTest() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
    }
}

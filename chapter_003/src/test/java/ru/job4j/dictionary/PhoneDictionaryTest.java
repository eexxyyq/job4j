package ru.job4j.dictionary;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {
        @Test
        public void whenFindByName() {
            var phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            var persons = phones.find("Pe");
            assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        }

        @Test
        public void whenFindByPhone() {
            var phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            phones.add(
                    new Person("Mikhael", "Sonner", "78952", "Berlin")
            );
            var persons = phones.find("789");
            assertThat(persons.iterator().next().getSurname(), is("Sonner"));
        }

        @Test
        public void whenFindByAddress() {
            var phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            var persons = phones.find("nsk");
            assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        }
}

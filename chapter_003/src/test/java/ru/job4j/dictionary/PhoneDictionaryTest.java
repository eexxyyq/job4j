package ru.job4j.dictionary;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {
        @Test
        public void whenFindByName() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            List<Person> persons = phones.find("Pe");
            assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        }

        @Test
        public void whenFindByPhone() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            phones.add(
                    new Person("Mikhael", "Sonner", "78952", "Berlin")
            );
            List<Person> persons = phones.find("789");
            assertThat(persons.iterator().next().getSurname(), is("Sonner"));
        }

        @Test
        public void whenFindByAddress() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            List<Person> persons = phones.find("nsk");
            assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        }
}

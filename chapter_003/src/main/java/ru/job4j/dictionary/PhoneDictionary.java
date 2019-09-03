package ru.job4j.dictionary;

import java.util.ArrayList;
import java.util.List;

class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();
    void add(Person person) {
        this.persons.add(person);
    }

    List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAddress().contains(key)
                    || person.getName().contains(key)
                    || person.getPhone().contains(key)
                    || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

}

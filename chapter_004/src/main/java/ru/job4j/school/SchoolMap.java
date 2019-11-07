package ru.job4j.school;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SchoolMap {
    public Map<String, Student> listToMap(List<Student> list) {
        return list.stream().distinct().collect(Collectors.toMap(
                Student::getName, student -> student
        ));
    }
}

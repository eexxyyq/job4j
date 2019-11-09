package ru.job4j.school;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchoolStreamAPI {
    List<Student> levelOf(List<Student> list, int bound) {
        return list.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .flatMap(Stream::ofNullable)
                .takeWhile(v -> v.getScore() > bound)
                .collect(Collectors.toList());
    }
}

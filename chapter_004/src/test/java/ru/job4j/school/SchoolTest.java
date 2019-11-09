package ru.job4j.school;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    private List<Student> getList() {
        List<Student> result = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            result.add(new Student(i, "student" + i));
        }
        return result;
    }
    @Test
    public void whenGetListForAClass() {
        School school = new School();
        List<Student> listOfAllStudents = getList();
        Predicate<Student> predicate = student -> student.getScore() >= 70 && student.getScore() <= 100;
        List<Student> expect = Arrays.asList(listOfAllStudents.get(6),
                listOfAllStudents.get(7),
                listOfAllStudents.get(8),
                listOfAllStudents.get(9));
        List<Student> result = school.collect(listOfAllStudents, predicate);
        assertThat(result, is(expect));
    }
    @Test
    public void whenGetListForBClass() {
        School school = new School();
        List<Student> listOfAllStudents = getList();
        Predicate<Student> predicate = student -> student.getScore() >= 50 && student.getScore() < 70;
        List<Student> expect = Arrays.asList(listOfAllStudents.get(4),
                listOfAllStudents.get(5));
        List<Student> result = school.collect(listOfAllStudents, predicate);
        assertThat(result, is(expect));
    }
    @Test
    public void whenGetListForCClass() {
        School school = new School();
        List<Student> listOfAllStudents = getList();
        Predicate<Student> predicate = student -> student.getScore() > 0 && student.getScore() < 50;
        List<Student> expect = Arrays.asList(listOfAllStudents.get(0),
                listOfAllStudents.get(1),
                listOfAllStudents.get(2),
                listOfAllStudents.get(3));
        List<Student> result = school.collect(listOfAllStudents, predicate);
        assertThat(result, is(expect));
    }

    @Test
    public void whenWantToConvertListToMap() {
        SchoolMap sm = new SchoolMap();
        List<Student> list = getList();
        Map<String, Student> result = sm.listToMap(list);
        Map<String, Student> expect = new HashMap<>();
        for (Student student : list) {
            expect.put(student.getName(), student);
        }
        assertThat(result, is(expect));
    }

    @Test
    public void whenWantToSortedListByBounds() {
        SchoolStreamAPI ssAPI = new SchoolStreamAPI();
        List<Student> list = getList();
        List<Student> result = ssAPI.levelOf(list, 50);
        List<Student> expected = List.of(list.get(9), list.get(8),
                list.get(7), list.get(6), list.get(5));
        assertThat(result, is(expected));
    }
}

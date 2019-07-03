package ru.job4j.profi.engeneers;

import ru.job4j.profi.Engineer;
import ru.job4j.profi.others.Project;

import java.util.Calendar;

public class Programmer extends Engineer {
    public int numOfLang;
    public String grade;

    public int getNumOfLang() {
        return numOfLang;
    }

    public String getGrade() {
        return grade;
    }

    public Programmer(String name, String surname, String education, Calendar birthday, int numOfLang, String grade) {
        super(name, surname, education, birthday);
        this.numOfLang = numOfLang;
        this.grade = grade;
    }

    public void codingProject(Project project) {

    }
}

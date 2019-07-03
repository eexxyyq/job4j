package ru.job4j.profi;

import java.util.Calendar;

public class Profession {
    public String name;
    public String surname;
    public String education;
    public Calendar birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public Profession(String name, String surname, String education, Calendar birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Profession(String name, String surname, String education) {
        this.name = name;
        this.surname = surname;
        this.education = education;
    }

    public Profession(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Profession() {
    }
}

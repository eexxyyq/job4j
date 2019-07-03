package ru.job4j.profi.medics;

import ru.job4j.profi.Doctor;
import ru.job4j.profi.others.Patient;

import java.util.Calendar;

public class Dentist extends Doctor {
    public int experience;

    public int getExperience() {
        return experience;
    }

    public Dentist(String name, String surname, String education, Calendar birthday, boolean medDiploma, int experience) {
        super(name, surname, education, birthday, medDiploma);
        this.experience = experience;
    }

    public void removeTeeth(Patient patient) {

    }
}

package ru.job4j.profi.medics;

import ru.job4j.profi.Doctor;
import ru.job4j.profi.others.Patient;

import java.util.Calendar;

public class Surgeon extends Doctor {
    public int numOfTypeOfOperations;
    public String[] typeOfOperations = new String[numOfTypeOfOperations];

    public String[] getTypeOfOperations() {
        return typeOfOperations;
    }

    public Surgeon(String name, String surname, String education, Calendar birthday, boolean medDiploma, String[] typeOfOperations) {
        super(name, surname, education, birthday, medDiploma);
        this.typeOfOperations = typeOfOperations;
    }

    public void healPatient(Patient patient) {

    }

}

package ru.job4j.profi;

import java.util.Calendar;

public class Doctor extends Profession {
    public boolean medDiploma;

    public boolean isMedDiploma() {
        return medDiploma;
    }

    public Doctor(String name, String surname, String education, Calendar birthday, boolean medDiploma) {
        super(name, surname, education, birthday);
        this.medDiploma = medDiploma;
    }

    public Doctor() {
    }
}

package ru.job4j.profi.engeneers;

import ru.job4j.profi.Engineer;
import ru.job4j.profi.others.Project;

import java.util.Calendar;

public class Builder extends Engineer {
    public String countryOfBirth;

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public Builder(String name, String surname, String education, Calendar birthday, String countryOfBirth) {
        super(name, surname, education, birthday);
        this.countryOfBirth = countryOfBirth;
    }

    public void createBuilding(Project project) {

    }
}

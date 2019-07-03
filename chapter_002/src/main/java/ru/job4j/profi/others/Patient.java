package ru.job4j.profi.others;

public class Patient {
    public String name;
    public String diagnose;

    public String getName() {
        return name;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public Patient(String name, String diagnose) {
        this.name = name;
        this.diagnose = diagnose;
    }

    public Patient(String name) {
        this.name = name;
    }

    public Patient() {
    }
}

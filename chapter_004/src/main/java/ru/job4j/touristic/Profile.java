package ru.job4j.touristic;

public class Profile {
    private Address address;

    Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    Profile(Address address) {
        this.address = address;
    }
}

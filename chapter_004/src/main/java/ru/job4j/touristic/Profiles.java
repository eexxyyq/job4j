package ru.job4j.touristic;

import java.util.List;
import java.util.stream.Collectors;

class Profiles {
    static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).collect(Collectors.toList());
    }
}

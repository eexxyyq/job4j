package ru.job4j.profi.others;

public class Project {
    public String name;
    public int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Project(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }
}

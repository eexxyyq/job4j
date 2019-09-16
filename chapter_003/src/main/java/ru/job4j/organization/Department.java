package ru.job4j.organization;

import java.util.Objects;

public class Department {
    private String name;
    private Department parent;

    public String getName() {
        return name;
    }

    public Department getParent() {
        return parent;
    }

    public Department(String name, Department parent) {
        this.name = name;
        this.parent = parent;
    }

    public Department(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return getName().equals(that.getName())
                && Objects.equals(getParent(), that.getParent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParent());
    }

    @Override
    public String toString() {
        StringBuilder fullName = new StringBuilder();
        Department dep = this;
        while (dep.getParent() != null) {
            fullName.insert(0, dep.getParent().getName() + "/");
            dep = dep.getParent();
        }
        return fullName + this.getName();
    }
}

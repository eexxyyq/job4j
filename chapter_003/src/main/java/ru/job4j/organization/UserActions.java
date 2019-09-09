package ru.job4j.organization;

import java.util.List;

public interface UserActions {
    void addDepartment(String name);
    void addDepartment(String name, String parent);
    List<Department> getListOfDepartmentAscendingSort();
    List<Department> getListOfDepartmentDescendingSort();
}

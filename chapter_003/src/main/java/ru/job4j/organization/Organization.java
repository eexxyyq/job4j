package ru.job4j.organization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Organization implements UserActions {
    private List<Department> listOfDepartment = new ArrayList<>();
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addDepartment(String name) {
        Department department = new Department(name);
        this.listOfDepartment.add(department);
    }

    @Override
    public void addDepartment(String name, String parentName) {
        Department parent = null;
        for (Department x : this.listOfDepartment) {
            if (x.toString().equals(parentName)) {
                parent = x;
            }
        }
        Department department = new Department(name, parent);
        this.listOfDepartment.add(department);

    }

    @Override
    public List<Department> getListOfDepartmentAscendingSort() {
        List<Department> result = this.listOfDepartment;
        Comparator<Department> comparator = new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
        result.sort(comparator);
        return result;
    }

    @Override
    public List<Department> getListOfDepartmentDescendingSort() {
        List<Department> result = this.listOfDepartment;
        Comparator<Department> comparator = new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                String superParentName1 = o1.getName();
                String superParentName2 = o2.getName();
                Department tmp1 = o1;
                Department tmp2 = o2;
                while (tmp1.getParent() != null) {
                    superParentName1 = tmp1.getParent().getName();
                    tmp1 = tmp1.getParent();
                }
                while (tmp2.getParent() != null) {
                    superParentName2 = tmp2.getParent().getName();
                    tmp2 = tmp2.getParent();
                }
                return superParentName2.compareTo(superParentName1);
            }
        };
        result.sort(comparator);
        return result;
    }
}

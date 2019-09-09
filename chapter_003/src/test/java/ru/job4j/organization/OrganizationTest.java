package ru.job4j.organization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrganizationTest {
    public Organization addOrganizationStructure() {
        Organization organization = new Organization("nike");
        organization.addDepartment("k1");
        organization.addDepartment("k2");
        organization.addDepartment("sk1", "k1");
        organization.addDepartment("sk1", "k2");
        organization.addDepartment("ssk1", "k1/sk1");
        organization.addDepartment("ssk2", "k1/sk1");
        organization.addDepartment("ssk1", "k2/sk1");
        organization.addDepartment("ssk2", "k2/sk1");
        return organization;
    }

    public List<Department> listForAscendingSort(){
        Department k1 = new Department("k1");
        Department sk1k1 = new Department("sk1", k1);
        Department ssk1sk1k1 = new Department("ssk1", sk1k1);
        Department ssk2sk1k1 = new Department("ssk2", sk1k1);
        Department k2 = new Department("k2");
        Department sk1k2 = new Department("sk1", k2);
        Department ssk1sk1k2 = new Department("ssk1", sk1k2);
        Department ssk2sk1k2 = new Department("ssk2", sk1k2);
        return new ArrayList<>(Arrays.asList(k1, sk1k1, ssk1sk1k1, ssk2sk1k1, k2, sk1k2, ssk1sk1k2, ssk2sk1k2));
    }

    public List<Department> listForDescendingSort() {
        Department k1 = new Department("k1");
        Department sk1k1 = new Department("sk1", k1);
        Department ssk1sk1k1 = new Department("ssk1", sk1k1);
        Department ssk2sk1k1 = new Department("ssk2", sk1k1);
        Department k2 = new Department("k2");
        Department sk1k2 = new Department("sk1", k2);
        Department ssk1sk1k2 = new Department("ssk1", sk1k2);
        Department ssk2sk1k2 = new Department("ssk2", sk1k2);
        return new ArrayList<>(Arrays.asList(k2, sk1k2, ssk1sk1k2, ssk2sk1k2, k1, sk1k1, ssk1sk1k1, ssk2sk1k1));
    }

    @Test
    public void whenAscendingSorting() {
        Organization org = addOrganizationStructure();
        List<Department> result = org.getListOfDepartmentAscendingSort();
        List<Department> except = listForAscendingSort();
        assertThat(result, is(except));
    }

    @Test
    public void whenDescendingSorting() {
        Organization org = addOrganizationStructure();
        List<Department> result = org.getListOfDepartmentDescendingSort();
        List<Department> expect = listForDescendingSort();
        assertThat(result, is(expect));

    }
}

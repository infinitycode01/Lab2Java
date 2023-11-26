package com.infinity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

public class DepartmentServiceStreamApiTest {
    DepartmentServiceStreamApi departmentService;
    List<Department> departments;
    Employee employee1, employee2, employee3;
    DevelopmentDepartment devDept1, devDept2, devDept3;

    @BeforeClass
    public void setUp() {
        employee1 = new Employee.Builder("Dima", 1, "Python...", 500.0).build();
        employee2 = new Employee.Builder("Anatoliy", 2, "Java Dev", 2000.0).build();
        employee3 = new Employee.Builder("Zubenko Mihail Petrovich", 3, "Tech Lead", 5000.0).build();

        devDept1 = new DevelopmentDepartment.Builder().setName("DevDept1").build();
        devDept1.addEmployee(employee1);
        devDept1.addEmployee(employee2);

        devDept2 = new DevelopmentDepartment.Builder().setName("DevDept2").build();
        devDept2.addEmployee(employee3);

        devDept3 = new DevelopmentDepartment.Builder().setName("DevDept3").build();

        departments = Arrays.asList(devDept1, devDept2, devDept3);

        departmentService = new DepartmentServiceStreamApi(departments);
    }

    @Test
    public void testSortDepartmentsByName() {
        List<Department> sortedDepartments = departmentService.sortDepartmentsByName();
        assertEquals(sortedDepartments.get(2).getName(), "DevDept3");
        assertEquals(sortedDepartments.get(1).getName(), "DevDept2");
    }

    @Test
    public void testFindDepartmentsByEmployee() {
        List<Department> departmentsWithEmployee = departmentService.findDepartmentsByEmployee(employee1);
        assertTrue(departmentsWithEmployee.contains(devDept1));
        assertFalse(departmentsWithEmployee.contains(devDept2));
        assertFalse(departmentsWithEmployee.contains(devDept3));
    }

    @Test
    public void testFindDepartmentsWithMoreThan() {
        List<Department> departmentsWithMoreThanOneEmployee = departmentService.findDepartmentsWithMoreThan(1);
        assertTrue(departmentsWithMoreThanOneEmployee.contains(devDept1));
        assertFalse(departmentsWithMoreThanOneEmployee.contains(devDept2));
        assertFalse(departmentsWithMoreThanOneEmployee.contains(devDept3));
    }

    @Test
    public void testSortDepartmentsByEmployeeCount() {
        List<Department> sortedByEmployeeCount = departmentService.sortDepartmentsByEmployeeCount();
        assertEquals(sortedByEmployeeCount.get(0), devDept1);
        assertEquals(sortedByEmployeeCount.get(1), devDept2);
    }
}

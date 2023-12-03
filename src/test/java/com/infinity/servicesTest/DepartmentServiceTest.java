package com.infinity.servicesTest;

import com.infinity.Department;
import com.infinity.DevelopmentDepartment;
import com.infinity.Employee;
import com.infinity.services.DepartmentService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

public class DepartmentServiceTest {
    DepartmentService departmentService;
    List<Department> departments;
    Employee employee1, employee2, employee3, employee4, employee5, employee6;
    DevelopmentDepartment devDept1, devDept2, devDept3;

    @BeforeClass
    public void setUp() {
        employee1 = new Employee.Builder("Dima", 1, "Python...", 600.0).build();
        employee2 = new Employee.Builder("Anatoliy", 2, "Java Dev", 2000.0).build();
        employee3 = new Employee.Builder("Zubenko Mihail Petrovich", 3, "Tech Lead", 5000.0).build();
        employee4 = new Employee.Builder("Dima", 4, "C", 600.0).build();
        employee5 = new Employee.Builder("Dima", 5, "C++", 600.0).build();
        employee6 = new Employee.Builder("Dima", 6, "C#", 600.0).build();


        devDept1 = new DevelopmentDepartment.Builder().setName("DevDept1").build();
        devDept1.addEmployee(employee1);
        devDept1.addEmployee(employee2);
        devDept1.addEmployee(employee3);

        devDept2 = new DevelopmentDepartment.Builder().setName("aDevDept2").build();
        devDept2.addEmployee(employee2);
        devDept2.addEmployee(employee5);


        devDept3 = new DevelopmentDepartment.Builder().setName("DevDept3").build();
        devDept3.addEmployee(employee3);


        departments = Arrays.asList(devDept2, devDept1, devDept3);

        departmentService = new DepartmentService(departments);
    }

    @Test
    public void testSortDepartmentsByName() {
        List<Department> sortedDepartments = departmentService.sortDepartmentsByName();

        assertEquals(sortedDepartments.get(0).getName(), "DevDept1");
        assertEquals(sortedDepartments.get(2).getName(), "aDevDept2");
        assertEquals(sortedDepartments.get(1).getName(), "DevDept3");
    }

    @Test
    public void testFindDepartmentsByEmployee() {
        List<Department> departmentsWithEmployee = departmentService.findDepartmentsByEmployee(employee3);
        assertEquals(departmentsWithEmployee.size(), 2);
        assertTrue(departmentsWithEmployee.contains(devDept1));

        assertTrue(departmentsWithEmployee.contains(devDept3));

    }

    @Test
    public void testFindDepartmentsWithMoreThan() {
        List<Department> departmentsWithMoreThanOneEmployee = departmentService.findDepartmentsWithMoreThan(1);
        assertEquals(departmentsWithMoreThanOneEmployee.size(), 2);

        assertTrue(departmentsWithMoreThanOneEmployee.contains(devDept1));
    }

    @Test
    public void testSortDepartmentsByEmployeeCount() {
        List<Department> sortedByEmployeeCount = departmentService.sortDepartmentsByEmployeeCount();

        assertEquals(sortedByEmployeeCount.get(0), devDept1);
        assertEquals(sortedByEmployeeCount.get(1), devDept2);
        assertEquals(sortedByEmployeeCount.get(2), devDept3);
    }
}

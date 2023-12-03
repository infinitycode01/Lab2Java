package com.infinity.services;

import com.infinity.Department;
import com.infinity.DevelopmentDepartment;
import com.infinity.Employee;
import com.infinity.interfaces.DepartmentServiceInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Service class for managing a collection of departments in an organization.
 * Provides methods to sort and search departments based on different criteria.
 */
public class DepartmentService implements DepartmentServiceInterface {
    private final List<Department> departments;

    /**
     * Constructs a DepartmentService with a given list of departments.
     *
     * @param departments The list of departments to be managed by this service.
     */
    public DepartmentService(List<Department> departments) {
        this.departments = departments;
    }

    /**
     * Sorts the departments by their names in ascending order.
     *
     * @return A list of departments sorted by name.
     */
    @Override
    public List<Department> sortDepartmentsByName() {
        departments.sort(Comparator.comparing(Department::getName));
        return departments;
    }

    /**
     * Finds and returns a list of departments that contain a specific employee.
     *
     * @param employee The employee to search for in the departments.
     * @return A list of departments that contain the specified employee.
     */
    @Override
    public List<Department> findDepartmentsByEmployee(Employee employee) {
        List<Department> foundDepartments = new ArrayList<>();
        for (Department department : departments) {
                if (department.getEmployees().contains(employee)) {
                    foundDepartments.add(department);
                }
        }
        return foundDepartments;
    }

    /**
     * Finds and returns a list of departments with more than a specified number of employees.
     *
     * @param employeeCount The threshold number of employees.
     * @return A list of departments that have more than the specified number of employees.
     */
    @Override
    public List<Department> findDepartmentsWithMoreThan(int employeeCount) {
        List<Department> foundDepartments = new ArrayList<>();
        for (Department department : departments) {
                if (department.getEmployees().size() > employeeCount) {
                    foundDepartments.add(department);
                }
        }
        return foundDepartments;
    }

    /**
     * Sorts the departments by the number of employees in each, in descending order.
     *
     * @return A list of departments sorted by the number of employees.
     */
    @Override
    public List<Department> sortDepartmentsByEmployeeCount() {
        departments.sort((d1, d2) -> Integer.compare(((DevelopmentDepartment) d2).getEmployeeCount(),
                ((DevelopmentDepartment) d1).getEmployeeCount()));
        return departments;
    }
}

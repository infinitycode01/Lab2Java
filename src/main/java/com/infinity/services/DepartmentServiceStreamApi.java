package com.infinity.services;

import com.infinity.Department;
import com.infinity.DevelopmentDepartment;
import com.infinity.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing a collection of departments in an organization.
 * Provides methods to sort and search departments based on different criteria, using Stream API.
 */
public class DepartmentServiceStreamApi{
    private final List<Department> departments;

    public DepartmentServiceStreamApi(List<Department> departments) {
        this.departments = departments;
    }

    /**
     * Sorts the departments by their names in ascending order using Stream API.
     *
     * @return A list of departments sorted by name.
     */
    public List<Department> sortDepartmentsByName() {
        return departments.stream()
                .sorted(Comparator.comparing(Department::getName))
                .collect(Collectors.toList());
    }

    /**
     * Finds and returns a list of departments that contain a specific employee using Stream API.
     *
     * @param employee The employee to search for in the departments.
     * @return A list of departments that contain the specified employee.
     */
    public List<Department> findDepartmentsByEmployee(Employee employee) {
        return departments.stream()
                .filter(department -> department instanceof DevelopmentDepartment)
                .map(department -> (DevelopmentDepartment) department)
                .filter(devDept -> devDept.getEmployees().contains(employee))
                .collect(Collectors.toList());
    }

    /**
     * Finds and returns a list of departments with more than a specified number of employees using Stream API.
     *
     * @param employeeCount The threshold number of employees.
     * @return A list of departments that have more than the specified number of employees.
     */
    public List<Department> findDepartmentsWithMoreThan(int employeeCount) {
        return departments.stream()
                .filter(department -> department instanceof DevelopmentDepartment)
                .map(department -> (DevelopmentDepartment) department)
                .filter(devDept -> devDept.getEmployeeCount() > employeeCount)
                .collect(Collectors.toList());
    }

    /**
     * Sorts the departments by the number of employees in each, in descending order, using Stream API.
     *
     * @return A list of departments sorted by the number of employees.
     */
    public List<Department> sortDepartmentsByEmployeeCount() {
        return departments.stream()
                .filter(department -> department instanceof DevelopmentDepartment)
                .sorted(Comparator.comparingInt((Department d) -> {
                    return ((DevelopmentDepartment) d).getEmployeeCount();
                }).reversed())
                .collect(Collectors.toList());
    }
}

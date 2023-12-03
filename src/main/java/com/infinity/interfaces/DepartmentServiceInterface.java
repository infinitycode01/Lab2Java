package com.infinity.interfaces;

import com.infinity.Department;
import com.infinity.Employee;

import java.util.List;

public interface DepartmentServiceInterface {
    List<Department> sortDepartmentsByName();

    List<Department> findDepartmentsByEmployee(Employee employee);

    List<Department> findDepartmentsWithMoreThan(int employeeCount);

    List<Department> sortDepartmentsByEmployeeCount();
}

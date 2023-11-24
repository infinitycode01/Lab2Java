package com.infinity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DevelopmentDepartment extends Department {
    private final List<Employee> employees;

    private DevelopmentDepartment(Builder builder) {
        super(builder);
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void describeDepartment() {
        System.out.println(getName() + " Department:");
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName());
        }
    }

    @Override
    public String toString() {
        return getName() + " Department{" +
                "employees = " + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevelopmentDepartment that = (DevelopmentDepartment) o;
        return Objects.equals(employees, that.employees) && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, getName());
    }

    public static class Builder extends Department.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public DevelopmentDepartment build() {
            return new DevelopmentDepartment(this);
        }
    }
}

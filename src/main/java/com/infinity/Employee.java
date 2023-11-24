package com.infinity;

import java.util.Objects;

public class Employee {
    private final String name;
    private final int id;
    private final String position;
    private final double salary;

    public Employee(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.position = builder.position;
        this.salary = builder.salary;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "\nEmployee {" +
                "name = '" + name + '\'' +
                ", id = " + id +
                ", position = '" + position + '\'' +
                ", salary = " + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name) &&
                position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, position, salary);
    }

    public static class Builder {
        private final String name;
        private int id;
        private final String position;
        private final double salary;

        public Builder(String name, int id, String position, double salary) {
            this.name = name;
            this.id = id;
            this.position = position;
            this.salary = salary;
        }
//        public Builder setId(int id) {
//            if (id < 0) {
//                throw new IllegalArgumentException("Id cannot be negative.");
//            }
//            this.id = id;
//            return this;
//        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

package com.infinity;

import java.util.Objects;

/**
 * Represents an employee with specific attributes like name, ID, position, and salary.
 */
public class Employee {
    private final String name;
    private final int id;
    private final String position;
    private final double salary;

    /**
     * Constructs an Employee instance with the specified attributes.
     *
     * @param builder The Builder object containing the data to initialize the Employee object.
     */
    public Employee(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.position = builder.position;
        this.salary = builder.salary;
    }

    /**
     * Returns the name of the employee.
     *
     * @return The name of this employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the employee.
     *
     * @return The ID of this employee.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the position of the employee.
     *
     * @return The position of this employee.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the salary of the employee.
     *
     * @return The salary of this employee.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Provides a string representation of the Employee object.
     *
     * @return A string representation of the Employee.
     */
    @Override
    public String toString() {
        return "\nEmployee {" +
                "name = '" + name + '\'' +
                ", id = " + id +
                ", position = '" + position + '\'' +
                ", salary = " + salary +
                '}';
    }

    /**
     * Compares this employee with the specified object for equality.
     *
     * @param o The object to compare with.
     * @return true if the specified object is equal to this employee; false otherwise.
     */
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

    /**
     * Returns a hash code value for the employee.
     *
     * @return A hash code value for this employee.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id, position, salary);
    }

    /**
     * Builder class for creating Employee objects.
     */
    public static class Builder {
        private final String name;
        private final int id;
        private final String position;
        private final double salary;

        /**
         * Creates a Builder instance for the Employee class with mandatory fields.
         *
         * @param name The name of the employee.
         * @param id The ID of the employee.
         * @param position The position of the employee.
         * @param salary The salary of the employee.
         */
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

        /**
         * Creates an Employee object using the current state of the Builder.
         *
         * @return A new Employee object.
         */
        public Employee build() {
            return new Employee(this);
        }
    }
}

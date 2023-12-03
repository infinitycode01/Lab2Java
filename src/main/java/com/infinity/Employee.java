package com.infinity;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

/**
 * Represents an employee with specific attributes like name, ID, position, and salary.
 */
public class Employee {
    protected String name;
    protected int id;
    protected String position;
    protected double salary;


    public Employee() {
    }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
     * Deserialize the string representation of the employee into an Employee object.
     *
     * @param str The string to deserialize.
     * @return An Employee object.
     */
    public static Employee fromString(String str) {
        String[] parts = str.split(",");
        Builder builder = new Builder(parts[0], Integer.parseInt(parts[1].trim()), parts[2], Double.parseDouble(parts[3].trim()));
        return new Employee(builder);
    }


    /**
     * Provides a string representation of the Employee object.
     *
     * @return A string representation of the Employee.
     */
    @Override
    public String toString() {
        return name + "," + id + "," + position + "," + salary;
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
        return name.equals(employee.name) &&
                position.equals(employee.position);
    }

    /**
     * Returns a hash code value for the employee.
     *
     * @return A hash code value for this employee.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    /**
     * Builder class for creating Employee objects.
     */
    public static class Builder {
        @NotBlank(message = "Name cannot be empty")
        protected String name;
        @Min(value = 1, message = "ID must be positive")
        protected int id;
        @NotBlank(message = "Position cannot be empty")
        protected String position;
        @Min(value = 500, message = "Salary must be greater than 500")
        protected double salary;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

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


        /**
         * Creates an Employee object using the current state of the Builder.
         *
         * @return A new Employee object.
         */
        public Employee build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Builder>> violations = validator.validate(this);

            if (!violations.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<Builder> violation : violations) {
                    sb.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
                }
                throw new IllegalArgumentException("Invalid fields: \n" + sb.toString());
            }

            return new Employee(this);
        }
    }
}

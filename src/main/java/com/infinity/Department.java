package com.infinity;



import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * Represents an abstract base class for different departments within a company.
 */
public abstract class Department implements Comparable<Department> {
    @NotNull
    private final String name;

    protected List<Employee> employees;

    /**
     * Constructs a Department instance with the specified attributes.
     *
     * @param builder The Builder object containing the data to initialize the Department object.
     */
    protected Department(Builder<?> builder) {
        this.name = builder.name;
    }

    /**
     * An abstract method that should be implemented to describe the specific department.
     */
    public abstract void describeDepartment();

    /**
     * Returns the name of the department.
     *
     * @return The name of this department.
     */
    public String getName() {
        return name;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    @Override
    public int compareTo(Department department){
        return employees.size() - department.employees.size();
    }

    /**
     * Abstract builder class for creating Department objects.
     * This class uses a generic type parameter to allow method chaining in subclasses.
     *
     * @param <T> The type of the builder to return. This allows method chaining.
     */
    public static abstract class Builder<T extends Builder<T>> {
        private String name;

        /**
         * Sets the name of the department.
         *
         * @param name The name to set for the department.
         * @return The builder instance.
         */
        public T setName(String name) {
            this.name = name;
            return self();
        }

        /**
         * Abstract method to be implemented by subclasses to return 'this' instance.
         *
         * @return The current builder instance.
         */
        protected abstract T self();

        /**
         * Abstract method to create a Department object.
         *
         * @return A new Department object.
         */
        public abstract Department build();
    }
}

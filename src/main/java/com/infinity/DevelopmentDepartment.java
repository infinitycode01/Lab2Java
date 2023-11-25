    package com.infinity;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Objects;

    /**
     * Represents the development department within a company, extending the Department class.
     */
    public class DevelopmentDepartment extends Department {
        private final List<Employee> employees;

        /**
         * Constructs a DevelopmentDepartment instance with the specified attributes.
         *
         * @param builder The Builder object containing the data to initialize the DevelopmentDepartment object.
         */
        private DevelopmentDepartment(Builder builder) {
            super(builder);
            this.employees = new ArrayList<>();
        }

        /**
         * Adds an employee to the development department.
         *
         * @param employee The employee to be added to the department.
         */
        public void addEmployee(Employee employee) {
            this.employees.add(employee);
        }

        /**
         * Returns a list of employees in the development department.
         *
         * @return A list of employees.
         */
        public List<Employee> getEmployees() {
            return employees;
        }

        /**
         * Returns the number of employees currently in the development department.
         *
         * @return The number of employees in the development department. The value is zero
         *         or greater, depending on the current size of the employee list.
         */
        public int getEmployeeCount() {
            return employees.size();
        }

        /**
         * Describes the department by printing details of each employee in the department.
         */
        @Override
        public void describeDepartment() {
            System.out.println(getName() + " Department:");
            for (Employee employee : employees) {
                System.out.println("Employee: " + employee.getName());
            }
        }

        /**
         * Provides a string representation of the DevelopmentDepartment object.
         *
         * @return A string representation of the DevelopmentDepartment.
         */
        @Override
        public String toString() {
            return getName() + " Department{" +
                    "employees = " + employees +
                    '}';
        }

        /**
         * Compares this development department with the specified object for equality.
         *
         * @param o The object to compare with.
         * @return true if the specified object is equal to this development department; false otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DevelopmentDepartment that = (DevelopmentDepartment) o;
            return Objects.equals(employees, that.employees) && getName().equals(that.getName());
        }

        /**
         * Returns a hash code value for the development department.
         *
         * @return A hash code value for this development department.
         */
        @Override
        public int hashCode() {
            return Objects.hash(employees, getName());
        }

        /**
         * Builder class for creating DevelopmentDepartment objects, extending the Department.Builder class.
         */
        public static class Builder extends Department.Builder<Builder> {
            /**
             * Provides this Builder instance for method chaining.
             *
             * @return The current builder instance.
             */
            @Override
            protected Builder self() {
                return this;
            }

            /**
             * Creates a DevelopmentDepartment object using the current state of the Builder.
             *
             * @return A new DevelopmentDepartment object.
             */
            @Override
            public DevelopmentDepartment build() {
                return new DevelopmentDepartment(this);
            }
        }
    }

package com.infinity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a tester, extending the Employee class with additional fields for types of testing and current project.
 */
public class Tester extends Employee {
    private final String[] typesOfTesting;
    private final String currentProject;

    /**
     * Constructs a Tester instance with the specified attributes.
     *
     * @param builder The Builder object containing the data to initialize the Tester object.
     */
    private Tester(Builder builder) {
        super(builder);
        this.typesOfTesting = builder.typesOfTesting;
        this.currentProject = builder.currentProject;
    }

    /**
     * Returns the types of testing the tester is skilled in.
     *
     * @return An array of strings representing the types of testing.
     */
    public String[] getTypesOfTesting() {
        return typesOfTesting;
    }

    /**
     * Returns the name of the current project the tester is working on.
     *
     * @return The name of the current project.
     */
    public String getCurrentProject() {
        return currentProject;
    }

    /**
     * Provides a string representation of the Tester object.
     *
     * @return A string representation of the Tester.
     */
    @Override
    public String toString() {
        return "\nTester {" +
                "name = '" + getName() + '\'' +
                ", id = " + getId() +
                ", position = '" + getPosition() + '\'' +
                ", salary = " + getSalary() +
                ", typesOfTesting  = " + Arrays.toString(typesOfTesting) +
                ", currentProject = '" + currentProject + '\'' +
                '}';
    }

    /**
     * Compares this tester with the specified object for equality.
     *
     * @param o The object to compare with.
     * @return true if the specified object is equal to this tester; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tester tester = (Tester) o;
        return getId() == tester.getId() &&
                Double.compare(tester.getSalary(), getSalary()) == 0 &&
                getName().equals(tester.getName()) &&
                getPosition().equals(tester.getPosition()) &&
                Arrays.equals(typesOfTesting, tester.typesOfTesting) &&
                Objects.equals(currentProject, tester.currentProject);
    }

    /**
     * Returns a hash code value for the tester.
     *
     * @return A hash code value for this tester.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(typesOfTesting);
        result = 31 * result + Objects.hashCode(currentProject);
        return result;
    }

    /**
     * Builder class for creating Tester objects, extending the Employee.Builder class.
     */
    public static class Builder extends Employee.Builder {
        private String[] typesOfTesting;
        private String currentProject;

        /**
         * Creates a Builder instance for the Tester class with mandatory fields.
         *
         * @param name The name of the tester.
         * @param id The ID of the tester.
         * @param position The position of the tester.
         * @param salary The salary of the tester.
         */
        public Builder(String name, int id, String position, double salary) {
            super(name, id, position, salary);
        }

        /**
         * Sets the types of testing for the tester.
         *
         * @param typesOfTesting An array of strings representing the types of testing.
         * @return The Builder instance.
         */
        public Builder setTypesOfTesting(String[] typesOfTesting) {
            this.typesOfTesting = typesOfTesting;
            return this;
        }

        /**
         * Sets the current project for the tester.
         *
         * @param currentProject The name of the current project.
         * @return The Builder instance.
         */
        public Builder setCurrentProject(String currentProject) {
            this.currentProject = currentProject;
            return this;
        }

        /**
         * Creates a Tester object using the current state of the Builder.
         *
         * @return A new Tester object.
         */
        @Override
        public Tester build() {
            List<String> validationErrors = new ArrayList<>();

            //validateEmployeeFields(validationErrors);

            if (typesOfTesting == null || typesOfTesting.length == 0) {
                validationErrors.add("Programming languages cannot be empty");
            }
            if (currentProject == null || currentProject.trim().isEmpty()) {
                validationErrors.add("Current project cannot be empty");
            }

            if (!validationErrors.isEmpty()) {
                throw new IllegalArgumentException("Illegal arguments: " + String.join(", ", validationErrors));
            }

            return new Tester(this);
        }

//        private void validateEmployeeFields(List<String> errors) {
//            if (getName() == null || getName().trim().isEmpty()) {
//                errors.add("Name cannot be empty");
//            }
//            if (getId() <= 0) {
//                errors.add("ID must be positive");
//            }
//            if (getPosition() == null || getPosition().trim().isEmpty()) {
//                errors.add("Position cannot be empty");
//            }
//            if (getSalary() < 500) {
//                errors.add("Salary must be greater than 500");
//            }
//        }
    }
}

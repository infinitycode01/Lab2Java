package com.infinity;


import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a developer, extending the Employee class with additional fields for programming languages and current project.
 */
public class Developer extends Employee {
    @NotBlank
    private final String[] programmingLanguages;
    @NotBlank
    private final String currentProject;

    /**
     * Constructs a Developer instance with the specified attributes.
     *
     * @param builder The Builder object containing the data to initialize the Developer object.
     */
    private Developer(Builder builder) {
        super(builder);
        this.programmingLanguages = builder.programmingLanguages;
        this.currentProject = builder.currentProject;
    }

    /**
     * Returns the programming languages known by the developer.
     *
     * @return An array of strings representing the programming languages.
     */

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    /**
     * Returns the name of the current project the developer is working on.
     *
     * @return The name of the current project.
     */
    public String getCurrentProject() {
        return currentProject;
    }

    /**
     * Provides a string representation of the Developer object.
     *
     * @return A string representation of the Developer.
     */
    @Override
    public String toString() {
        return "Developer {" +
                "name = '" + getName() + '\'' +
                ", id = " + getId() +
                ", position = '" + getPosition() + '\'' +
                ", salary = " + getSalary() +
                ", programmingLanguages  = " + Arrays.toString(programmingLanguages) +
                ", currentProject = '" + currentProject + '\'' +
                '}' + "\n";
    }

    /**
     * Compares this developer with the specified object for equality.
     *
     * @param o The object to compare with.
     * @return true if the specified object is equal to this developer; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return getId() == developer.getId() &&
                Double.compare(developer.getSalary(), getSalary()) == 0 &&
                getName().equals(developer.getName()) &&
                getPosition().equals(developer.getPosition()) &&
                Arrays.equals(programmingLanguages, developer.programmingLanguages) &&
                Objects.equals(currentProject, developer.currentProject);
    }

    /**
     * Returns a hash code value for the developer.
     *
     * @return A hash code value for this developer.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(programmingLanguages);
        result = 31 * result + Objects.hashCode(currentProject);
        return result;
    }

    /**
     * Builder class for creating Developer objects, extending the Employee.Builder class.
     */
    public static class Builder extends Employee.Builder {
        private String[] programmingLanguages;
        private String currentProject;

        /**
         * Creates a Builder instance for the Developer class with mandatory fields.
         *
         * @param name The name of the developer.
         * @param id The ID of the developer.
         * @param position The position of the developer.
         * @param salary The salary of the developer.
         */
        public Builder(String name, int id, String position, double salary) {
            super(name, id, position, salary);
        }

        /**
         * Sets the programming languages for the developer.
         *
         * @param programmingLanguages An array of strings representing the programming languages.
         * @return The Builder instance.
         */
        public Builder setProgrammingLanguages(String[] programmingLanguages) {
            this.programmingLanguages = programmingLanguages;
            return this;
        }

        /**
         * Sets the current project for the developer.
         *
         * @param currentProject The name of the current project.
         * @return The Builder instance.
         */
        public Builder setCurrentProject(String currentProject) {
            this.currentProject = currentProject;
            return this;
        }

        /**
         * Creates a Developer object using the current state of the Builder.
         *
         * @return A new Developer object.
         */
        @Override
        public Developer build() {
//            super.build();
//
//            List<String> validationErrors = new ArrayList<>();
//
//            if (name == null || name.trim().isEmpty()) {
//                validationErrors.add("Name cannot be empty");
//            }
//            if (id <= 0) {
//                validationErrors.add("ID must be positive");
//            }
//            if (position == null || position.trim().isEmpty()) {
//                validationErrors.add("Position cannot be empty");
//            }
//            if (salary < 2000) {
//                validationErrors.add("Salary must be greater than 500");
//            }
//
//            if (programmingLanguages == null || programmingLanguages.length == 0) {
//                validationErrors.add("Programming languages cannot be empty");
//            }
//            if (currentProject == null || currentProject.trim().isEmpty()) {
//                validationErrors.add("Current project cannot be empty");
//            }
//
//            if (!validationErrors.isEmpty()) {
//                throw new IllegalArgumentException("Illegal arguments: " + String.join(", ", validationErrors));
//            }

            return new Developer(this);
        }


    }
}

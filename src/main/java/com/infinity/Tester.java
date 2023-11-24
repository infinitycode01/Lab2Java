package com.infinity;

import java.util.Arrays;
import java.util.Objects;

public class Tester extends Employee {
    private final String[] typesOfTesting;
    private final String currentProject;

    private Tester(Builder builder) {
        super(builder);
        this.typesOfTesting = builder.typesOfTesting;
        this.currentProject = builder.currentProject;
    }

    public String[] getTypesOfTesting() {
        return typesOfTesting;
    }

    public String getCurrentProject() {
        return currentProject;
    }

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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(typesOfTesting);
        result = 31 * result + Objects.hashCode(currentProject);
        return result;
    }

    public static class Builder extends Employee.Builder {
        private String[] typesOfTesting;
        private String currentProject;

        public Builder(String name, int id, String position, double salary) {
            super(name, id, position, salary);
        }

        public Builder setTypesOfTesting(String[] typesOfTesting) {
            this.typesOfTesting = typesOfTesting;
            return this;
        }

        public Builder setCurrentProject(String currentProject) {
            this.currentProject = currentProject;
            return this;
        }

        @Override
        public Tester build() {
            return new Tester(this);
        }
    }
}

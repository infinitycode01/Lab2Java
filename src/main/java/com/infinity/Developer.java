package com.infinity;

import java.util.Arrays;
import java.util.Objects;

public class Developer extends Employee {
    private final String[] programmingLanguages;
    private final String currentProject;

    private Developer(Builder builder) {
        super(builder);
        this.programmingLanguages = builder.programmingLanguages;
        this.currentProject = builder.currentProject;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    @Override
    public String toString() {
        return "\nDeveloper {" +
                "name = '" + getName() + '\'' +
                ", id = " + getId() +
                ", position = '" + getPosition() + '\'' +
                ", salary = " + getSalary() +
                ", programmingLanguages  = " + Arrays.toString(programmingLanguages) +
                ", currentProject = '" + currentProject + '\'' +
                '}';
    }

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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(programmingLanguages);
        result = 31 * result + Objects.hashCode(currentProject);
        return result;
    }

    public static class Builder extends Employee.Builder {
        private String[] programmingLanguages;
        private String currentProject;

        public Builder(String name, int id, String position, double salary) {
            super(name, id, position, salary);
        }

        public Builder setProgrammingLanguages(String[] programmingLanguages) {
            this.programmingLanguages = programmingLanguages;
            return this;
        }

        public Builder setCurrentProject(String currentProject) {
            this.currentProject = currentProject;
            return this;
        }

        @Override
        public Developer build() {
            return new Developer(this);
        }
    }
}

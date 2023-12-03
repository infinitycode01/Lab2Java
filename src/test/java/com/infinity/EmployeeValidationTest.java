package com.infinity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeValidationTest {

    @Test
    public void testValidEmployee() {
        Employee.Builder builder = new Employee.Builder("dima", 123, "Developer", 1000.0);
        Employee employee = builder.build();

        Assert.assertEquals(employee.getName(), "dima");
        Assert.assertEquals(employee.getId(), 123);
        Assert.assertEquals(employee.getPosition(), "Developer");
        Assert.assertEquals(employee.getSalary(), 1000.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*Name cannot be empty.*")
    public void testInvalidName() {
        Employee.Builder builder = new Employee.Builder("", 123, "Developer", 1000.0);
        builder.build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*ID must be positive.*")
    public void testInvalidId() {
        Employee.Builder builder = new Employee.Builder("dima", -1, "Developer", 1000.0);
        builder.build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*Position cannot be empty.*")
    public void testInvalidPosition() {
        Employee.Builder builder = new Employee.Builder("dima", 123, "", 1000.0);
        builder.build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*Salary must be greater than 500.*")
    public void testInvalidSalary() {
        Employee.Builder builder = new Employee.Builder("dima", 123, "Developer", 400.0);
        builder.build();
    }
}

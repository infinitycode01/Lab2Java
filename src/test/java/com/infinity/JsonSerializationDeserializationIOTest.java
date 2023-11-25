package com.infinity;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonSerializationDeserializationIOTest {

    private JsonSerializationDeserializationIO<Employee> format;
    private List<Employee> employees;
    private final String testFilePath = "test_employees.json";

    @BeforeClass
    public void setUp() {
        format = new JsonSerializationDeserializationIO<>(Employee.class);
        employees = Arrays.asList(
                new Employee.Builder("Dima", 1, "HR", 1000)
                        .build(),
                new Employee.Builder("Dima3", 2, "Manager", 2000)
                        .build());
    }

    @Test
    public void testSerialize() {
        String json = format.serialize(employees.get(1));
        Assert.assertNotNull(json);
        Assert.assertTrue(json.contains("Dima3"));
    }

    @Test
    public void testDeserialize() {
        String json = format.serialize(employees.get(0));
        Employee employee = format.deserialize(json);
        Assert.assertNotNull(employee);
        Assert.assertEquals(employee.getSalary(), 1000);
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        format.writeToFile(employees, testFilePath);
        Assert.assertTrue(Files.exists(Paths.get(testFilePath)));
    }

    @Test
    public void testReadFromFile() throws IOException {
        format.writeToFile(employees, testFilePath);
        List<Employee> readEmployees = format.readFromFile(testFilePath);
        Assert.assertNotNull(readEmployees);
        Assert.assertFalse(readEmployees.isEmpty());
        Assert.assertEquals(readEmployees.size(), employees.size());
    }
}

package com.infinity.serializationDeserializationIOTest;

import com.infinity.Employee;
import com.infinity.serializationDeserializationIO.TxtSerializationDeserializationIO;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TxtSerializationDeserializationIOTest {

    private TxtSerializationDeserializationIO<Employee> format;
    private String testFilePath = "test_employees.txt";

    @BeforeClass
    public void setUp() {
        format = new TxtSerializationDeserializationIO<>(Employee::fromString);
    }

    @Test
    public void testSerializeAndDeserialize() throws IOException {
        Employee employee = new Employee.Builder("Dima", 1, "Java Junior", 1000).build();
        String serialized = format.serialize(employee);

        Assert.assertNotNull(serialized);
        Assert.assertFalse(serialized.isEmpty());

        Employee deserialized = format.deserialize(serialized);
        Assert.assertNotNull(deserialized);
        Assert.assertEquals(deserialized.getName(), "Dima");
        Assert.assertEquals(deserialized.getId(), 1);
    }



    @Test
    public void testWriteToFileAndReadFromFile() throws IOException {
        List<Employee> employees = Arrays.asList(
                new Employee.Builder("Dima1", 2, "Java Middle", 2000).build(),
                new Employee.Builder("Albert", 3, "Java Senior", 5000).build(),
                new Employee.Builder("Dima3", 4, "Java Junior", 1000).build()
        );
        format.writeToFile(employees, testFilePath);

        Assert.assertTrue(Files.exists(Paths.get(testFilePath)));

        List<Employee> readEmployees = format.readFromFile(testFilePath);

        Assert.assertNotNull(readEmployees);
        Assert.assertEquals(readEmployees.size(), 3);
        Assert.assertEquals(readEmployees.get(0).getName(), "Dima1");
        Assert.assertEquals(readEmployees.get(1).getName(), "Albert");
    }
}

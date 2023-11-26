package com.infinity.serializationDeserializationIOTest;

import com.infinity.Employee;
import com.infinity.serializationDeserializationIO.XmlSerializationDeserializationIO;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class XmlSerializationDeserializationIOTest {

    private XmlSerializationDeserializationIO<Employee> xmlFormat;
    private Employee employee;
    private String testFilePath = "test_employee.xml";

    @BeforeClass
    public void setUp() {
        xmlFormat = new XmlSerializationDeserializationIO<>(Employee.class);
        employee = new Employee.Builder("Dima", 1, "Java", 60000).build();
    }

    @Test
    public void testSerializeAndDeserialize() throws IOException {
        String xml = xmlFormat.serialize(employee);
        Assert.assertNotNull(xml);
        Assert.assertFalse(xml.isEmpty());

        Employee deserialized = xmlFormat.deserialize(xml);
        Assert.assertNotNull(deserialized);
        Assert.assertEquals(deserialized.getName(), employee.getName());
    }

    @Test
    public void testWriteToFileAndReadFromFile() throws IOException {
        List<Employee> employees = Arrays.asList(employee, new Employee.Builder("Dima", 2, "java", 80000).build());
        xmlFormat.writeToFile(employees, testFilePath);

        Assert.assertTrue(Files.exists(Paths.get(testFilePath)));

        List<Employee> readEmployees = xmlFormat.readFromFile(testFilePath);
        Assert.assertNotNull(readEmployees);
        Assert.assertEquals(readEmployees.size(), employees.size());
        Assert.assertEquals(readEmployees.get(0).getName(), employee.getName());
    }
}

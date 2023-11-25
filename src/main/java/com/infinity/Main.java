package com.infinity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            XmlSerializationDeserializationIO<Employee> format = new XmlSerializationDeserializationIO<>(Employee.class);

            // Створення об'єкта Employee
            Employee employee = new Employee.Builder("John Doe", 1, "Developer", 60000).build();

            // Серіалізація об'єкта в XML
            String xml = format.serialize(employee);
            System.out.println("Serialized XML:\n" + xml);

            // Десеріалізація об'єкта з XML
            Employee deserializedEmployee = format.deserialize(xml);
            System.out.println("Deserialized Employee:\n" + deserializedEmployee);

            // Запис об'єктів у файл
            List<Employee> employees = Arrays.asList(employee, new Employee.Builder("Jane Smith", 2, "Manager", 80000).build());
            String filePath = "employees.xml";
            format.writeToFile(employees, filePath);
            System.out.println("Employees written to file: " + filePath);

            // Читання об'єктів з файлу
            List<Employee> readEmployees = format.readFromFile(filePath);
            System.out.println("Employees read from file:");
            for (Employee emp : readEmployees) {
                System.out.println(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

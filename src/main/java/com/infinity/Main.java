package com.infinity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializationFormat<Developer> developerFormat = new JsonSerializationFormat<>(Developer.class);

        // Example serialization
        Developer dev1 = new Developer.Builder("Dima", 1, "Junior Java", 1200)
                .setProgrammingLanguages(new String[]{"Java"})
                .setCurrentProject("Project X")
                .build();
        String json = developerFormat.serialize(dev1);

        // Example deserialization
        Developer deserializedEmployee = developerFormat.deserialize(json);

        System.out.println(deserializedEmployee);

        // File operations
        List<Developer> dev = new ArrayList<>();
        dev.add(dev1);
        developerFormat.writeToFile(dev, "employees.json");
        List<Developer> readEmployees = developerFormat.readFromFile("employees.json");
    }
}

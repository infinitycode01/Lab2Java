package com.infinity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DepartmentTest {
    @Test
    public void testDepartmentCreation() {
        Developer dev1 = new Developer.Builder("Dima", 1, "Junior Java Spring", 1000.0)
                .setProgrammingLanguages(new String[]{"Java", "C++"})
                .setCurrentProject("Project X")
                .build();

        Developer dev2 = new Developer.Builder("Dima", 2, "Middle Java Spring", 2000.0)
                .setProgrammingLanguages(new String[]{"Java", "C++", "Python"})
                .setCurrentProject("Project X")
                .build();

        Tester test1 = new Tester.Builder("Dima", 3, "Junior QA Engeenier", 600.0)
                .setTypesOfTesting(new String[]{"Manual"})
                .setCurrentProject("Project X")
                .build();

        DevelopmentDepartment devDep = new DevelopmentDepartment.Builder()
                .setName("Development")
                .build();

        devDep.addEmployee(dev1);
        devDep.addEmployee(dev2);
        devDep.addEmployee(test1);

        Assert.assertEquals(devDep.getName(), "Development");
        Assert.assertEquals(devDep.getEmployeeCount(), 3);
    }
}

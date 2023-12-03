package com.infinity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeveloperTest {
    @Test
    public void testDeveloperCreation() {
        Developer developer1 = new Developer.Builder("Dima", 1, "Junior Java Spring", 1000.0)
                .setProgrammingLanguages(new String[]{"Java", "C++"})
                .setCurrentProject("Project X")
                .build();
        Assert.assertEquals(developer1.getName(), "Dima");
        Assert.assertEquals(developer1.getId(), 1);
        Assert.assertEquals(developer1.getPosition(), "Junior Java Spring");
        Assert.assertEquals(developer1.getSalary(), 1000.0);
        Assert.assertEquals(developer1.getProgrammingLanguages(), new String[]{"Java", "C++"});
        Assert.assertEquals(developer1.getCurrentProject(), "Project X");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDeveloperCreationWithInvalidData() {
        new Developer.Builder("", -1, "", -500)
                .setProgrammingLanguages(new String[]{})
                .setCurrentProject(" ")
                .build();
    }
}

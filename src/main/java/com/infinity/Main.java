package com.infinity;

public class Main {
    public static void main(String[] args) {
        Developer dev1, dev2, dev3;
        Tester test1, test2, test3;
        dev1 = new Developer.Builder("Dima", -1, "Junior Java Software Developer", 1000.0)
                .setProgrammingLanguages(new String[]{"Java", "Python", "JavaScript"})
                .setCurrentProject("Project X")
                .build();

        dev2 = new Developer.Builder("Dima", 2, "Middle Java Software Developer", 1500.0)
                .setProgrammingLanguages(new String[]{"Java", "C++"})
                .setCurrentProject("Project Y")
                .build();

        test1 = new Tester.Builder("Goga", 5, "C++", 2000.0)
                .setTypesOfTesting(new String[]{"Manual", "Automatic"})
                .setCurrentProject("Projec X")
                .build();

        test2 = new Tester.Builder("Goga", 5, "C++", 2000.0)
                .setTypesOfTesting(new String[]{"Manual", "Automatic"})
                .setCurrentProject("Projec X")
                .build();

        test3 = new Tester.Builder("Goga", 5, "C++", 2000.0)
                .setTypesOfTesting(new String[]{"Manual"})
                .setCurrentProject("Projec Y")
                .build();

        dev3 = new Developer.Builder("Dima", -1, "Middle Java Software Developer", 1500.0)
                .setProgrammingLanguages(new String[]{"Java", "C++"})
                .setCurrentProject("Project Y")
                .build();


        //System.out.println(dev);

        DevelopmentDepartment devDept = new DevelopmentDepartment.Builder()
                .setName("Development")
                .build();

        devDept.addEmployee(dev1);
        devDept.addEmployee(dev2);
        devDept.addEmployee(test1);
        System.out.println(devDept);
    }
}
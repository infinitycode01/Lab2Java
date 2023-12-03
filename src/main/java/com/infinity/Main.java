package com.infinity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");


        Employee empl = new Employee.Builder("dima", 1, "Java", 600)
                .build();

        System.out.println(empl);
    }
}

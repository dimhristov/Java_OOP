package com.company.p1_SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " is " + this.age + " years old.";
    }
}

package com.company.p3_ValidationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private DecimalFormat format;

    public Person() {
        this.format = new DecimalFormat("#.0####");
    }


    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols.");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number");
        }
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this();
        this.setSalary(salary);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }



    public void increaseSalary(Double bonus) {
        if (this.age > 30) {
            this.salary +=this.salary * bonus/100;
        } else {
            this.salary += this.salary * bonus / 200;
        }
    }

    public Double getSalary() {
        return this.salary;
    }

    private void setSalary(Double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary must be more than 460 lv");
        }
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.format.format(this.salary) + " leva";
    }
}

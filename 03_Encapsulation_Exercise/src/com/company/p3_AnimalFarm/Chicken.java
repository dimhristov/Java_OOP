package com.company.p3_AnimalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private double calculateProductPerDay() {
        if (this.age > 0 && this.age < 6) {
            return 2;
        } else if (this.age >= 6 && this.age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",this.name,this.age,df.format(this.calculateProductPerDay()));
    }
}

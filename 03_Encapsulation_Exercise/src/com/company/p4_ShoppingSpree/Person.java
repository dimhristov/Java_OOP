package com.company.p4_ShoppingSpree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person() {
        this.bagOfProducts = new ArrayList<>();
    }

    public Person(String name, double money) {
        this();
        this.setName(name);
        this.setMoney(money);

    }

    public void addProducts(Product product) {
        if (this.money >= product.getCost()) {
            getBagOfProducts().add(product);
            this.money = this.money - product.getCost();
            System.out.println(String.format("%s bought %s", this.name, product.getName()));
        } else {
            System.out.println(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(Double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private List<Product> getBagOfProducts() {
        return this.bagOfProducts;
    }

    private List<String> getNamesFromBagOfProducts() {
        List<String> names = new ArrayList<>();
        for (Product product : bagOfProducts) {
            names.add(product.getName());
        }
        return names;
    }


    public void printThatPerson() {
        System.out.print(String.format("%s - ", this.name));
        if (this.bagOfProducts.isEmpty()) {
            System.out.println("Nothing bought");
        } else {
            System.out.println(Arrays.toString(getNamesFromBagOfProducts().toArray()).replaceAll("[\\[\\]]", ""));
        }
    }
}

package com.company.p4_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();

        String[] names = reader.readLine().split(";");
        for (String ppl : names) {
            String[] tokens = ppl.split("=");
            String name = tokens[0];
            Double money = Double.parseDouble(tokens[1]);
            try {
                Person person = new Person(name, money);
                personList.add(person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        String[] productsInput = reader.readLine().split(";");
        for (String s : productsInput) {
            String[] tokens = s.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);
            try {
                Product product = new Product(name, cost);
                productsList.add(product);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }

        String cmd = reader.readLine();
        while (!"END".equals(cmd)) {
            String[] tokens = cmd.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            for (Person person : personList) {
                if (person.getName().equals(personName)) {
                    for (Product product : productsList) {
                        if (product.getName().equals(productName)) {
                            person.addProducts(product);
                        }
                    }
                }
            }

            cmd = reader.readLine();
        }
        for (Person person : personList) {
            person.printThatPerson();
        }

    }
}

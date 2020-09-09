package com.company.p3_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!"End".equals(input)) {
            String[] animalInput = input.split("\\s+");
            String animalType = animalInput[0];
            String animalName = animalInput[1];
            Double animalWeight = Double.valueOf((animalInput[2]));
            String animalLivingRegion = animalInput[3];
            String catBreed = "";
            if (animalInput.length > 4) {
                catBreed = animalInput[4];
            }
            Animal animal = null;
            Food food = null;
            try {
                if (animalType.equals("Mouse")) {
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                } else if (animalType.equals("Zebra")) {
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                } else if (animalType.equals("Cat")) {
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                } else if (animalType.equals("Tiger")) {
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            String[] foodInput = reader.readLine().split("\\s+");
            String foodType = foodInput[0];
            Integer quantity = Integer.parseInt(foodInput[1]);

            if (foodType.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else if (foodType.equals("Meat")) {
                food = new Meat(quantity);
            }

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            System.out.println(animal);

            input = reader.readLine();

        }
    }
}

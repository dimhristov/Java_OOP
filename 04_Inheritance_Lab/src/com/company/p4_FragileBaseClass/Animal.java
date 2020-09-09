package com.company.p4_FragileBaseClass;

import java.util.Collections;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public final void eatAll(Food[] food) {
        Collections.addAll(foodEaten, food);
    }
}

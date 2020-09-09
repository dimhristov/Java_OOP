package com.company.p3_WildFarm;

public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    protected void setQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be a positive number");
        }
        this.quantity = quantity;
    }

    protected Integer getQuantity() {
        return this.quantity;
    }
}

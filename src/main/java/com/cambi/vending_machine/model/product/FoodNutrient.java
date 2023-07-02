package com.cambi.vending_machine.model.product;

public class FoodNutrient {
    private int foodNutrientId;
    private float amount;
    private int fdcId;
    private int nutrientId;

    // Constructors (optional)

    public FoodNutrient() {
    }

    public FoodNutrient(int foodNutrientId, float amount, int fdcId, int nutrientId) {
        this.foodNutrientId = foodNutrientId;
        this.amount = amount;
        this.fdcId = fdcId;
        this.nutrientId = nutrientId;
    }

    // Getters and Setters

    public int getFoodNutrientId() {
        return foodNutrientId;
    }

    public void setFoodNutrientId(int foodNutrientId) {
        this.foodNutrientId = foodNutrientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }
}

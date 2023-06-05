package com.cambi.vending_machine.model.product;

public class ProductNutrient {
    private String name;
    private String unit;
    private double amount;
    private String nutrientType;
    public ProductNutrient(){}
    public ProductNutrient(String name, String unit, double amount, String nutrientType) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.nutrientType = nutrientType;
    }
    public double getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }
    public String getUnit() {
        return unit;
    }
    public String getNutrientType() {
        return nutrientType;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public void setNutrientType(String nutrientType) {
        this.nutrientType = nutrientType;
    }
    @Override
    public String toString() {
        return "ProductNutrient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                ", nutrientType='" + nutrientType + '\'' +
                '}';
    }
}


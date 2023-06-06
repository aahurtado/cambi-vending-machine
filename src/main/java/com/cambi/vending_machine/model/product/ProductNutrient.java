package com.cambi.vending_machine.model.product;

public class ProductNutrient {
    private String name;
    private String unit;
    private double amount;
    public ProductNutrient(){}
    public ProductNutrient(String name, String unit, double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
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
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    @Override
    public String toString() {
        return "ProductNutrient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                '}';
    }
}


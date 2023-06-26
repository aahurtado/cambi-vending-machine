package com.cambi.vending_machine.model.product;

import com.cambi.vending_machine.model.Nutrient.Nutrient;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class ProductNutrient extends Nutrient {
    private BigDecimal amount;

    public ProductNutrient() {};

    public ProductNutrient(String nutrientName, String unit, String nutrientGroupName, BigDecimal amount) {
        super(nutrientName, unit, nutrientGroupName);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductNutrient{" +
                "amount=" + amount +
                ", nutrientName='" + getNutrientName() + '\'' +
                ", unit='" + getUnit() + '\'' +
                ", nutrientGroupName='" + getNutrientGroupName() + '\'' +
                '}';
    }
}



package com.cambi.vending_machine.model.product;

import com.cambi.vending_machine.model.Nutrient.Nutrient;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class ProductNutrient {

    private String nutrientName;
    private BigDecimal amount;

    private int productId;

    public ProductNutrient() {};

    public ProductNutrient(String nutrientName, BigDecimal amount, int productId) {
        this.nutrientName = nutrientName;
        this.amount = amount;
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    @Override
    public String toString() {
        return "ProductNutrient{" +
                "nutrientName='" + nutrientName + '\'' +
                ", amount=" + amount +
                ", productId=" + productId +
                '}';
    }
}



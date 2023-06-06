package com.cambi.vending_machine.model.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String gtinUpc;
    private List<ProductNutrientGroup> productNutrientsGroups = new ArrayList<>();
    private int productId;

    public Product () {}
    public Product (String gtinUpc, List<ProductNutrientGroup> productNutrientsGroups , int productId) {
        this.gtinUpc = gtinUpc;
        this.productId = productId;
        this.productNutrientsGroups = productNutrientsGroups;
    }
    public String getGtinUpc() {
        return gtinUpc;
    }
    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    public int getProductId() {
        return productId;
    }

    public List<ProductNutrientGroup> getProductNutrientsGroups() {
        return productNutrientsGroups;
    }

    public void setProductNutrientsGroups(List<ProductNutrientGroup> productNutrientsGroups) {
        this.productNutrientsGroups = productNutrientsGroups;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductNutrientGroups(List<ProductNutrientGroup> productNutrientGroups) {
        this.productNutrientsGroups = productNutrientGroups;
    }
    public ProductNutrientGroup getNutrientGroupByName(String name) {
        for (ProductNutrientGroup nutrientGroup : productNutrientsGroups) {
            if (nutrientGroup.getGroupName().equals(name)) {
                return nutrientGroup;
            }
        }
        return null; // Group not found
    }
}

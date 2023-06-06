package com.cambi.vending_machine.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductNutrientGroup {
    String productNutrientName;
    private List<ProductNutrient> productNutrientsGroups = new ArrayList<>();

    public List<ProductNutrient> getProductNutrients() {
        return productNutrientsGroups;
    }

    public String getGroupName() {
        return productNutrientName;
    }

    public void setProductNutrientsGroups(List<ProductNutrient> productNutrientsGroups) {
        this.productNutrientsGroups = productNutrientsGroups;
    }

    public void setGroupName(String groupName) {
        this.productNutrientName = groupName;
    }

    public void setNutrientGroupName(String nutrientGroupName) {
        this.productNutrientName = nutrientGroupName;
    }

    public String getProductNutrientName() {
        return productNutrientName;
    }



}

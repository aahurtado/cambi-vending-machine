package com.cambi.vending_machine.model.Nutrient;

import java.util.ArrayList;

public class Nutrient {
    private String nutrientName;
    private String unitName;

    private String nutrientGroupName;
    public Nutrient() {};

    public Nutrient(String nutrientName, String unitName) {
        this.nutrientName = nutrientName;
        this.unitName = unitName;
        this.nutrientName = nutrientName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unit) {
        this.unitName = unit;
    }

    public String getNutrientGroupName() {
        return nutrientGroupName;
    }

    public void setNutrientGroupName(String nutrientGroupName) {
        this.nutrientGroupName = nutrientGroupName;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "nutrientName='" + nutrientName + '\'' +
                ", unit='" + unitName + '\'' +
                '}';
    }

}

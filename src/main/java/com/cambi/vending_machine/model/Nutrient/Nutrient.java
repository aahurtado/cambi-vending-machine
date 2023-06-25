package com.cambi.vending_machine.model.Nutrient;

import java.util.ArrayList;

public class Nutrient {
    private String nutrientName;
    private String unit;

    private String nutrientGroupName;
    public Nutrient() {};

    public Nutrient(String nutrientName, String unit, String nutrientGroupName) {
        this.nutrientName = nutrientName;
        this.unit = unit;
        this.nutrientName = nutrientName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
                ", unit='" + unit + '\'' +
                ", nutrientGroupName='" + nutrientGroupName + '\'' +
                '}';
    }

}

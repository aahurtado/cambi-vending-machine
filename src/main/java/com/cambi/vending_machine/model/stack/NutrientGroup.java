package com.cambi.vending_machine.model.stack;

import java.util.List;

public class NutrientGroup {
    private String nutrientGroupType;
    private double weight;
    private List<Nutrient> nutrients;

    public NutrientGroup(){};
    public NutrientGroup(String nutrientGroup, double weight, List<Nutrient> nutrientRanges) {
        this.nutrientGroupType = nutrientGroup;
        this.weight = weight;
        this.nutrients = nutrientRanges;
    }

    public double getWeight() {
        return weight;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public String getNutrientGroup() {
        return nutrientGroupType;
    }

    public void setNutrientGroup(String nutrientGroup) {
        this.nutrientGroupType = nutrientGroup;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NutrientGroup{" +
                "nutrientGroupType='" + nutrientGroupType + '\'' +
                ", weight=" + weight +
                ", nutrients=" + nutrients +
                '}';
    }
}
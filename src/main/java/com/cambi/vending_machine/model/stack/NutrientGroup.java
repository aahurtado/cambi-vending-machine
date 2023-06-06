package com.cambi.vending_machine.model.stack;

import java.util.List;

public class NutrientGroup {
    private String nutrientGroupName;
    private double weight;
    private List<Nutrient> nutrients;

    public NutrientGroup(){};
    public NutrientGroup(String nutrientGroup, double weight, List<Nutrient> nutrientRanges) {
        this.nutrientGroupName = nutrientGroup;
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
        return nutrientGroupName;
    }

    public void setNutrientGroup(String nutrientGroup) {
        this.nutrientGroupName = nutrientGroup;
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
                "nutrientGroupType='" + nutrientGroupName + '\'' +
                ", weight=" + weight +
                ", nutrients=" + nutrients +
                '}';
    }
}
package com.cambi.vending_machine.model.stack;

import java.util.List;

public class Nutrient {
    private String name;
    private String unit;
    private List<NutrientRange> ranges;

    public Nutrient(){};
    public Nutrient(String name, String unit, List<NutrientRange> ranges) {
        this.name = name;
        this.unit = unit;
        this.ranges = ranges;
    }
    public String getName() {
        return name;
    }
    public List<NutrientRange> getRanges() {
        return ranges;
    }
    public String getUnit() {
        return unit;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRanges(List<NutrientRange> ranges) {
        this.ranges = ranges;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", ranges=" + ranges +
                '}';
    }
}
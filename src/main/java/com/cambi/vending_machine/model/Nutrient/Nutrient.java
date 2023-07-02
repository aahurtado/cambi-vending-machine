package com.cambi.vending_machine.model.Nutrient;

public class Nutrient {
    private int nutrientIdPk;
    private int nutrientId;
    private String nutrientNumber;
    private String nutrientName;
    private int nutrientRank;
    private String unitName;

    // Constructors (optional)

    public Nutrient() {
    }

    public Nutrient(int nutrientIdPk, int nutrientId, String nutrientNumber, String nutrientName,
                    int nutrientRank, String unitName) {
        this.nutrientIdPk = nutrientIdPk;
        this.nutrientId = nutrientId;
        this.nutrientNumber = nutrientNumber;
        this.nutrientName = nutrientName;
        this.nutrientRank = nutrientRank;
        this.unitName = unitName;
    }

    // Getters and Setters

    public int getNutrientIdPk() {
        return nutrientIdPk;
    }

    public void setNutrientIdPk(int nutrientIdPk) {
        this.nutrientIdPk = nutrientIdPk;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getNutrientNumber() {
        return nutrientNumber;
    }

    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public int getNutrientRank() {
        return nutrientRank;
    }

    public void setNutrientRank(int nutrientRank) {
        this.nutrientRank = nutrientRank;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "nutrientIdPk=" + nutrientIdPk +
                ", nutrientId=" + nutrientId +
                ", nutrientNumber='" + nutrientNumber + '\'' +
                ", nutrientName='" + nutrientName + '\'' +
                ", nutrientRank=" + nutrientRank +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}

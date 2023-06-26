package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.model.Nutrient.Nutrient;

import java.util.List;

public interface NutrientDao {
    void createNutrient(Nutrient nutrient);
    Nutrient getNutrient(String nutrientName);
    void updateNutrient(Nutrient nutrientName);
    void deleteNutrient(String nutrientName);
}

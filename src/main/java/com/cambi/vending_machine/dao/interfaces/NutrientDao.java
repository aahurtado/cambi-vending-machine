package com.cambi.vending_machine.dao.interfaces;

import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.Nutrient.NutrientGroup;

import java.util.List;

public interface NutrientDao {
    void createNutrient(Nutrient nutrient);
    Nutrient getNutrient(String name);
    void updateNutrient(Nutrient nutrient);
    void deleteNutrient(String name);

    List <Nutrient> getAllNutrients();

    //TODO implement these
    default NutrientGroup getNutrientGroup(int nutrientGroupName) {
        return null;
    };
    default List<NutrientGroup> getAllNutrientGroups() {
        return null;
    };


}

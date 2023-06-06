package com.cambi.vending_machine.model.stack;




import java.util.List;


public class PreferenceStack{
    private int userId;
    private List<NutrientGroup> nutrientGroups;

    public PreferenceStack(){};
    public PreferenceStack(int userId, List<NutrientGroup> nutrientGroups) {
        this.userId = userId;
        this.nutrientGroups = nutrientGroups;
    }

    public int getUserId() {
        return userId;
    }

    public List<NutrientGroup> getNutrientGroups() {
        return nutrientGroups;
    }

    public void setNutrientGroups(List<NutrientGroup> nutrientGroups) {
        this.nutrientGroups = nutrientGroups;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public NutrientGroup getNutrientGroupByName(String nutrientgroupName) {
        for (NutrientGroup nutrientGroup : nutrientGroups) {
            if (nutrientGroup.getNutrientGroup().equalsIgnoreCase(nutrientgroupName)) {
                return nutrientGroup;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public String toString() {
        return "PreferenceStack{" +
                "userId=" + userId +
                ", nutrientGroups=" + nutrientGroups +
                '}';
    }
}











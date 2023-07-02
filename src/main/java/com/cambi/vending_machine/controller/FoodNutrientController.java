package com.cambi.vending_machine.controller;

import com.cambi.vending_machine.dao.FoodNutrientDao;
import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.product.FoodNutrient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/foodNutrients")
@RestController
public class FoodNutrientController {
    private final FoodNutrientDao foodNutrientDao;

    public FoodNutrientController(FoodNutrientDao foodNutrientDao) {
        this.foodNutrientDao = foodNutrientDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFoodNutrient (@RequestBody FoodNutrient foodNutrient) {
        foodNutrientDao.createFoodNutrient(foodNutrient);
    }
}

package com.cambi.vending_machine.controller;


import com.cambi.vending_machine.dao.interfaces.NutrientDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/nutrient")
@RestController
public class NutrientController {

    private NutrientDao nutrientDao;

    NutrientController(NutrientDao nutrientDao) {
        this.nutrientDao = nutrientDao;
    }
    @PostMapping
    public void createNutrient(Nutrient nutrient) {

    }

    @GetMapping
    public Nutrient getNutrient(String nutrientName) {
        return nutrientDao.getNutrient(nutrientName);
    }

}

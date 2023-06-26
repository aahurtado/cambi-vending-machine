package com.cambi.vending_machine.controller;


import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/nutrient")
@RestController
public class NutrientController {

    private NutrientDao nutrientDao;

    NutrientController(NutrientDao nutrientDao) {
        this.nutrientDao = nutrientDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createNutrient (@RequestBody Nutrient nutrient) {
        nutrientDao.createNutrient(nutrient);
        return true;
    }

    @GetMapping
    public Nutrient getNutrient(@RequestParam String nutrientName) {
        return nutrientDao.getNutrient(nutrientName);
    }

    @PutMapping
    public boolean updateNutrient(@RequestBody Nutrient nutrient) {
        nutrientDao.updateNutrient(nutrient);
        return true;
    }

    @DeleteMapping
    public boolean deleteNutrient(@RequestParam String nutrientName) {
        nutrientDao.deleteNutrient(nutrientName);
        return true;
    }

}

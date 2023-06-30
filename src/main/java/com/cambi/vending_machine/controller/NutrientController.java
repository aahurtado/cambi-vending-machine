package com.cambi.vending_machine.controller;


import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.dao.exceptions.GetException;
import com.cambi.vending_machine.dao.exceptions.UpdateException;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/nutrients")
@RestController
public class NutrientController {

    private final NutrientDao nutrientDao;

    NutrientController(NutrientDao nutrientDao) {
        this.nutrientDao = nutrientDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNutrient (@RequestBody Nutrient nutrient) {
            nutrientDao.createNutrient(nutrient);
    }
    @GetMapping
    public Nutrient getNutrient(@RequestParam String nutrientName) throws Exception {
            return nutrientDao.getNutrient(nutrientName);
    }
    @PutMapping
    public void updateNutrient(@RequestBody Nutrient nutrient) throws Exception {
            nutrientDao.updateNutrient(nutrient);
    }
    @DeleteMapping
    public void deleteNutrient(@RequestParam String nutrientName) {
        nutrientDao.deleteNutrient(nutrientName);
    }

}

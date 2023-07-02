package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.model.product.FoodNutrient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcFoodNutrientDao implements FoodNutrientDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFoodNutrientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createFoodNutrient(FoodNutrient foodNutrient) {
        String sql = "INSERT INTO food_nutrient (food_nutrient_id, amount, fdc_id, nutrient_id)" +
                " VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, foodNutrient.getFoodNutrientId(), foodNutrient.getAmount(), foodNutrient.getFdcId(), foodNutrient.getNutrientId());
        } catch (DataAccessException e) {
            throw new CreateException("Unable to create food nutrient " + e);
        }
    }

}



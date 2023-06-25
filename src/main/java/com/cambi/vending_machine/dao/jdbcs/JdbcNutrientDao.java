package com.cambi.vending_machine.dao.jdbcs;

import com.cambi.vending_machine.dao.interfaces.NutrientDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcNutrientDao implements NutrientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcNutrientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void createNutrient(Nutrient nutrient) {

    }

    @Override
    public Nutrient getNutrient(String nutrientName) {
        String sql = "SELECT nutrient_name, unit, nutrient_group_name FROM nutrient WHERE nutrient_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, nutrientName);
        if (results.next()) {
            return mapRowToNutrient(results);
        }
       return null;
    }

    @Override
    public void updateNutrient(Nutrient nutrient) {

    }

    @Override
    public void deleteNutrient(String name) {

    }

    @Override
    public List<Nutrient> getAllNutrients() {
        return null;
    }

    private Nutrient mapRowToNutrient(SqlRowSet rs) {
        Nutrient nutrient = new Nutrient();
        nutrient.setNutrientName(rs.getString("nutrient_name"));
        nutrient.setUnit(rs.getString("unit"));
        nutrient.setNutrientGroupName(rs.getString("nutrient_group_name"));
        return nutrient;
    }
}
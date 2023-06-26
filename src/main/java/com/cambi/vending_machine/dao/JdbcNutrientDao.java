package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.dao.exceptions.DeleteException;
import com.cambi.vending_machine.dao.exceptions.GetException;
import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import org.springframework.dao.DataAccessException;
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
        String sql = "INSERT INTO nutrient" +
                " (nutrient_name, unit_name, nutrient_group_name)" +
                " VALUES (?, ?, ?)";

        try {
            jdbcTemplate.update(sql, nutrient.getNutrientName(), nutrient.getUnitName(), nutrient.getNutrientGroupName());
        } catch (DataAccessException e) {
            throw new CreateException(e);
        }
    }

    @Override
    public Nutrient getNutrient(String nutrientName) {
        String sql = "SELECT nutrient_name, unit_name, nutrient_group_name FROM nutrient WHERE nutrient_name = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, nutrientName);
            if (results.next()) {
                return mapRowToNutrient(results);
            }
            // this return null is reached if the object is not found
            //TODO implement logic for this in controller
            return null;
        } catch (DataAccessException e) {
            throw new GetException(e);
        }
    }


    @Override
    public void updateNutrient(Nutrient nutrient) {
        String sql ="UPDATE nutrient" +
                " SET unit_name = ?, nutrient_group_name = ?" +
                " WHERE nutrient_name = ?";
        try {
            jdbcTemplate.update(sql, nutrient.getUnitName(), nutrient.getNutrientGroupName(), nutrient.getNutrientName());
        } catch (DataAccessException e) {
            throw new CreateException(e);
        }
    }

    @Override
    public void deleteNutrient(String nutrientName) {
        String sql = "DELETE FROM nutrient WHERE nutrient_name = ?";
        try {
            jdbcTemplate.update(sql, nutrientName);
        } catch (DataAccessException e) {
            throw new DeleteException(e);
        }
    }

    @Override
    public List<Nutrient> getAllNutrients() {
        return null;
    }

    private Nutrient mapRowToNutrient(SqlRowSet rs) {
        Nutrient nutrient = new Nutrient();
        nutrient.setNutrientName(rs.getString("nutrient_name"));
        nutrient.setUnitName(rs.getString("unit_name"));
        nutrient.setNutrientGroupName(rs.getString("nutrient_group_name"));
        return nutrient;
    }
}
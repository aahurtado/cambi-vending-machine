package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.dao.exceptions.DeleteException;
import com.cambi.vending_machine.dao.exceptions.GetException;
import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.dao.exceptions.UpdateException;
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
        System.out.println(nutrient.toString());
        String sql = "INSERT INTO nutrient" +
                " (nutrient_id, nutrient_number, nutrient_name, nutrient_rank, unit_name)" +
                " VALUES (?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, nutrient.getNutrientId(), nutrient.getNutrientNumber(),
                    nutrient.getNutrientName(), nutrient.getNutrientRank(), nutrient.getUnitName());
        } catch (DataAccessException e) {
            throw new CreateException("Unable to create nutrient", e);
        }
    }

    //    @Override
//    public Nutrient getNutrient(String nutrientName) throws GetException {
//        String sql = "SELECT nutrient_name, unit_name, nutrient_group_name FROM nutrient WHERE nutrient_name = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, nutrientName);
//        if (results.next()) {
//            return mapRowToNutrient(results);
//        }
//        throw new GetException("Unable to get nutrient");
//    }
//    @Override
//    public void updateNutrient(Nutrient nutrient) {
//        String sql ="UPDATE nutrient" +
//                " SET unit_name = ?, nutrient_group_name = ?" +
//                " WHERE nutrient_name = ?";
//        try {
//            jdbcTemplate.update(sql, nutrient.getUnitName(), nutrient.getNutrientGroupName(), nutrient.getNutrientName());
//        } catch (DataAccessException e) {
//            throw new UpdateException("Unable to update nutrient");
//        }
//    }
//    @Override
//    public void deleteNutrient(String nutrientName) {
//        String sql = "DELETE FROM nutrient WHERE nutrient_name = ?";
//        try {
//            jdbcTemplate.update(sql, nutrientName);
//        } catch (DataAccessException e) {
//            throw new DeleteException("Unable to delete nutrient");
//        }
//    }
    private Nutrient mapRowToNutrient(SqlRowSet rs) {
        Nutrient nutrient = new Nutrient();
        nutrient.setNutrientIdPk(rs.getInt("nutrient_id_pk"));
        nutrient.setNutrientId(rs.getInt("nutrient_id"));
        nutrient.setNutrientNumber(rs.getString("nutrient_number"));
        nutrient.setNutrientName(rs.getString("nutrient_name"));
        nutrient.setNutrientRank(rs.getInt("nutrient_rank"));
        nutrient.setUnitName(rs.getString("unit_name"));
        return nutrient;
    }
}
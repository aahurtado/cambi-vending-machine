package com.cambi.vending_machine.dao;
import java.sql.Timestamp;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.product.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Component
public class JdbcProductDao implements ProductDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProduct(Product product) {
        String sql =
                "INSERT INTO product ( gtin_upc, publication_date, modified_date, brand_owner, food_category, description," +
                        " household_serving_full_text, serving_size_unit, serving_size)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";


        Date date = new Date();

        // Create a SimpleDateFormat object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Format the date
        String formattedDate = dateFormat.format(date);

        // Create a Timestamp object
        Timestamp currentTimestamp = Timestamp.valueOf(formattedDate);

        try {
            jdbcTemplate.update(sql, product.getGtinUpc(), currentTimestamp,
                    currentTimestamp, product.getBrandOwner(), product.getFoodCategory(),
                    product.getDescription(), product.getHouseHoldServingFullText(), product.getServingSizeUnit(),
                    product.getServingSize());
        } catch (DataAccessException e) {
            throw new CreateException(e);
        }
    }


        @Override
    public Product getProductByUpc(String gtinUpc) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductByUpc(String gtinUpc) {

    }

    private Product mapRowToProduct(SqlRowSet rs) {
        Product product = new Product();
        product.setGtinUpc(rs.getString("gtin_upc"));
        product.setBrandOwner(rs.getString("brand_owner"));
        product.setFoodCategory(rs.getString("food_category"));
        product.setDescription(rs.getString("description"));
        product.setHouseHoldServingFullText(rs.getString("household_serving_full_text"));
        product.setServingSizeUnit(rs.getString("serving_size_unit"));
        product.setServingSize(rs.getBigDecimal("serving_size"));
        return product;
    }
}

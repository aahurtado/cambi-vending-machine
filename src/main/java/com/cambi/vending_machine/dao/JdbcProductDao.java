package com.cambi.vending_machine.dao;
import java.sql.Timestamp;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.product.ProductNutrient;
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
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING product_id";

        // get current timestamp to set publication and modified date
        Timestamp currentTimestamp = getCurrentTimeStamp();

        // product ID is returned when creating a product and used to insert the nutrients
        Integer productId;

        try {
            productId = jdbcTemplate.queryForObject(sql, Integer.class, product.getGtinUpc(), currentTimestamp, currentTimestamp, product.getBrandOwner(), product.getFoodCategory(),
            product.getDescription(), product.getHouseHoldServingFullText(), product.getServingSizeUnit(),
            product.getServingSize());
        } catch (DataAccessException e) {
            throw new CreateException(e);
        }
        sql = "INSERT INTO product_nutrient (amount, nutrient_name, product_id) VALUES (?, ?, ?);";

        for (ProductNutrient productNutrient: product.getProductNutrients()) {
            jdbcTemplate.update(sql, productNutrient.getAmount(), productNutrient.getNutrientName(), productId);
        }
    }


        @Override
    public Product getProductByUpc(String gtinUpc) {
        return null;
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

    private ProductNutrient mapRowToProductNutrient(SqlRowSet rs) {
        ProductNutrient productNutrient= new ProductNutrient();
        productNutrient.setNutrientName(rs.getString("nutrient_name"));
        productNutrient.setAmount(rs.getBigDecimal("amount"));
        productNutrient.setProductId(rs.getInt("product_id"));
        return productNutrient;
    }

    private Timestamp getCurrentTimeStamp() {
        Date date = new Date();
        // Create a SimpleDateFormat object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Format the date
        String formattedDate = dateFormat.format(date);
        // Create a Timestamp object
        Timestamp currentTimestamp = Timestamp.valueOf(formattedDate);
        return currentTimestamp;
    }
}


//    @Override
//    public List<Group> getAllGroups() {
//        List<Group> groups = new ArrayList<>();
//        String sql = "SELECT * FROM groups ORDER BY group_name";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            Group group = mapRowToGroup(results);
//            groups.add(group);
//        }
//        return groups;
//    }
package com.cambi.vending_machine.dao;
import java.sql.Timestamp;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.dao.exceptions.DeleteException;
import com.cambi.vending_machine.dao.exceptions.GetException;
import com.cambi.vending_machine.dao.exceptions.UpdateException;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.product.FoodNutrient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class JdbcProductDao implements ProductDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProduct(Product product) throws CreateException {
        String sql = "INSERT INTO product" +
                " (fdc_id, available_date, brand_owner, data_source, description, gtin_upc, household_serving_full_text," +
                " ingredients, modified_date, publication_date, serving_size, serving_size_unit, branded_food_category)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, product.getFdcId(), product.getAvailableDate(), product.getBrandOwner(),
                    product.getDataSource(), product.getDescription(), product.getGtinUpc(),
                    product.getHouseholdServingFullText(), product.getIngredients(), product.getModifiedDate(),
                    product.getPublicationDate(), product.getServingSize(), product.getServingSizeUnit(),
                    product.getBrandedFoodCategory());
        } catch (DataAccessException e) {
            throw new CreateException("Unable to create product", e);
        }
    }


//        String sql =
//                "INSERT INTO product ( gtin_upc, publication_date, modified_date, brand_owner, food_category, description," +
//                        " household_serving_full_text, serving_size_unit, serving_size)" +
//                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING product_id";
//
//        // get current timestamp to set publication and modified date
//        Timestamp currentTimestamp = getCurrentTimeStamp();
//
//        // product ID is returned when creating a product and used to insert the nutrients
//        Integer productId;
//
//        try {
//            productId = jdbcTemplate.queryForObject(sql, Integer.class, product.getGtinUpc(), currentTimestamp, currentTimestamp, product.getBrandOwner(), product.getFoodCategory(),
//            product.getDescription(), product.getHouseHoldServingFullText(), product.getServingSizeUnit(),
//            product.getServingSize());
//        } catch (DataAccessException e) {
//            throw new CreateException("Unable to create product");
//        }
//        sql = "INSERT INTO product_nutrient (amount, nutrient_name, product_id) VALUES (?, ?, ?);";
//
//        try {
//            for (FoodNutrient productNutrient : product.getProductNutrients()) {
//                jdbcTemplate.update(sql, productNutrient.getAmount(), productNutrient.getNutrientName(), productId);
//            }
//        }
//        catch(DataAccessException e) {
//            throw new CreateException("Unable to create product");
//        }

    //}
//        @Override
//    public Product getProductByUpc(String gtinUpc) throws GetException {
//
//        String sql = "SELECT product_id, gtin_upc, publication_date, modified_date, brand_owner, food_category, description," +
//                " household_serving_full_text, serving_size_unit, serving_size" +
//                " FROM product WHERE gtin_upc = ?";
//        Product product = null;
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gtinUpc);
//        if (results.next()) {
//            product = mapRowToProduct(results);
//        }
//
//        sql = "SELECT amount, nutrient_name, product_id FROM product_nutrient WHERE product_id = ?";
//        if (product != null) {
//            results = jdbcTemplate.queryForRowSet(sql, product.getProductId());
//            while (results.next()) {
//                FoodNutrient productNutrient = mapRowToProductNutrient(results);
//                product.getProductNutrients().add(productNutrient);
//            }
//            return product;
//        }
//        throw new GetException("Product not found");
//    }
//    @Override
//    @Transactional
//    public void updateProduct(Product product) {
//        String sql =
//                "UPDATE product SET gtin_upc = ?, modified_date = ?, brand_owner = ?, food_category = ?, description = ?," +
//                        " household_serving_full_text = ?, serving_size_unit = ?, serving_size = ?" +
//                        " WHERE product_id = ?";
//        try {
//            jdbcTemplate.update(sql,
//                product.getGtinUpc(),
//                getCurrentTimeStamp(),
//                product.getBrandOwner(),
//                product.getFoodCategory(),
//                product.getDescription(),
//                product.getHouseHoldServingFullText(),
//                product.getServingSizeUnit(),
//                product.getServingSize(),
//                product.getProductId());
//        } catch (DataAccessException e) {
//            throw new UpdateException("Unable to update product");
//        }
//
//        sql = "UPDATE product_nutrient SET amount = ?, nutrient_name = ? WHERE product_id = ?";
//
//        try {
//            for (FoodNutrient productNutrient : product.getProductNutrients()) {
//                jdbcTemplate.update(sql,
//                        productNutrient.getAmount(),
//                        productNutrient.getNutrientName(),
//                        product.getProductId());
//            }
//        } catch (DataAccessException e) {
//            throw new UpdateException("Unable to update product");
//        }
//
//    }
//
//    @Transactional
//    @Override
//    public void deleteProductByUpc(String gtinUpc) {
//        String deleteProductSql = "DELETE FROM product WHERE gtin_upc = ?";
//        String deleteProductNutrientsSql = "DELETE FROM product_nutrient WHERE product_id IN (SELECT product_id FROM product WHERE gtin_upc = ?)";
//        try {
//            jdbcTemplate.update(deleteProductNutrientsSql, gtinUpc);
//            jdbcTemplate.update(deleteProductSql, gtinUpc);
//        } catch (DataAccessException e) {
//            throw new DeleteException("Unable to delete product");
//        }
//    }
    private Product mapRowToProduct(SqlRowSet rs) {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setFdcId(rs.getInt("fdc_id"));
        product.setAvailableDate(rs.getString("available_date"));
        product.setBrandOwner(rs.getString("brand_owner"));
        product.setDataSource(rs.getString("data_source"));
        product.setDescription(rs.getString("description"));
        product.setGtinUpc(rs.getString("gtin_upc"));
        product.setHouseholdServingFullText(rs.getString("household_serving_full_text"));
        product.setIngredients(rs.getString("ingredients"));
        product.setModifiedDate(rs.getString("modified_date"));
        product.setPublicationDate(rs.getString("publication_date"));
        product.setServingSize(rs.getInt("serving_size"));
        product.setServingSizeUnit(rs.getString("serving_size_unit"));
        product.setBrandedFoodCategory(rs.getString("branded_food_category"));
        return product;
    }
    private FoodNutrient mapRowToFoodNutrient(SqlRowSet rs) {
        FoodNutrient foodNutrient = new FoodNutrient();
        foodNutrient.setFoodNutrientId(rs.getInt("food_nutrient_id"));
        foodNutrient.setAmount(rs.getFloat("amount"));
        foodNutrient.setFdcId(rs.getInt("fdc_id"));
        foodNutrient.setNutrientId(rs.getInt("nutrient_id"));
        return foodNutrient;
    }

//    private Timestamp getCurrentTimeStamp() {
//        Date date = new Date();
//        // Create a SimpleDateFormat object
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        // Format the date
//        String formattedDate = dateFormat.format(date);
//        // Create a Timestamp object
//        Timestamp currentTimestamp = Timestamp.valueOf(formattedDate);
//        return currentTimestamp;
//    }
}

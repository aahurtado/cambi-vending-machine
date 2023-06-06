package com.cambi.vending_machine.dao.jdbcs;

import com.cambi.vending_machine.dao.interfaces.TestDao;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.product.ProductNutrient;
import com.cambi.vending_machine.model.product.ProductNutrientGroup;
import com.cambi.vending_machine.model.stack.Nutrient;
import com.cambi.vending_machine.model.stack.NutrientGroup;
import com.cambi.vending_machine.model.stack.NutrientRange;
import com.cambi.vending_machine.model.stack.PreferenceStack;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTestDao implements TestDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getTest() {
        String sql = "SELECT test_id FROM test";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    public Product getProduct(int productId) {
        String productSql = "SELECT gtin_upc FROM product WHERE id = ?";
        String productNutrientGroupSql = "SELECT ng.group_name, pn.name, pn.unit, pn.amount " +
                "FROM nutrient_group ng " +
                "JOIN product_nutrient pn ON pn.id = pn.id " +
                "WHERE pn.product_id = ?";

        Product product = jdbcTemplate.queryForObject(productSql, new Object[]{productId}, (rs, rowNum) -> {
            Product p = new Product();
            p.setProductId(productId);
            p.setGtinUpc(rs.getString("gtin_upc"));
            return p;
        });

        List<ProductNutrientGroup> productNutrientGroups = new ArrayList<>();

        jdbcTemplate.query(productNutrientGroupSql, new Object[]{productId}, (rs, rowNum) -> {
            String nutrientGroupName = rs.getString("group_name");
            String nutrientName = rs.getString("name");
            String unit = rs.getString("unit");
            double amount = rs.getDouble("amount");

            ProductNutrient productNutrient = new ProductNutrient();
            productNutrient.setName(nutrientName);
            productNutrient.setUnit(unit);
            productNutrient.setAmount(amount);

            ProductNutrientGroup productNutrientGroup = getProductNutrientGroupByName(productNutrientGroups, nutrientGroupName);
            if (productNutrientGroup == null) {
                productNutrientGroup = new ProductNutrientGroup();
                productNutrientGroup.setNutrientGroupName(nutrientGroupName);
                productNutrientGroups.add(productNutrientGroup);
            }
            productNutrientGroup.getProductNutrients().add(productNutrient);

            return null;
        });

        product.setProductNutrientGroups(productNutrientGroups);

        return product;
    }

    private ProductNutrientGroup getProductNutrientGroupByName(List<ProductNutrientGroup> productNutrientGroups, String nutrientGroupName) {
        for (ProductNutrientGroup group : productNutrientGroups) {
            if (group.getGroupName().equals(nutrientGroupName)) {
                return group;
            }
        }
        return null;
    }




    @Override

    public PreferenceStack getPreferenceStack(int userId) {
        String preferenceStackSql = "SELECT id FROM preference_stack WHERE user_id = ?";
        String nutrientGroupSql = "SELECT nutrient_group_id, group_name, weight FROM nutrient_group";
        String nutrientSql = "SELECT id, name, unit FROM nutrient";
        String nutrientRangeSql = "SELECT id, min, max, score FROM nutrient_range";

        PreferenceStack preferenceStack = jdbcTemplate.queryForObject(preferenceStackSql, new Object[]{userId}, (rs, rowNum) -> {
            PreferenceStack stack = new PreferenceStack();
            stack.setUserId(userId);
            return stack;
        });

        List<NutrientGroup> nutrientGroups = jdbcTemplate.query(nutrientGroupSql, (rs, rowNum) -> {
            NutrientGroup nutrientGroup = new NutrientGroup();
            nutrientGroup.setNutrientGroup(rs.getString("group_name"));
            nutrientGroup.setWeight(rs.getDouble("weight"));
            return nutrientGroup;
        });

        for (NutrientGroup nutrientGroup : nutrientGroups) {
            List<Nutrient> nutrients = jdbcTemplate.query(nutrientSql, (rs, rowNum) -> {
                Nutrient nutrient = new Nutrient();
                nutrient.setName(rs.getString("name"));
                nutrient.setUnit(rs.getString("unit"));
                return nutrient;
            });

            for (Nutrient nutrient : nutrients) {
                List<NutrientRange> ranges = jdbcTemplate.query(nutrientRangeSql, (rs, rowNum) -> {
                    NutrientRange nutrientRange = new NutrientRange();
                    nutrientRange.setMin(rs.getInt("min"));
                    nutrientRange.setMax(rs.getInt("max"));
                    nutrientRange.setScore(rs.getDouble("score"));
                    return nutrientRange;
                });

                nutrient.setRanges(ranges);
            }

            nutrientGroup.setNutrients(nutrients);
        }

        preferenceStack.setNutrientGroups(nutrientGroups);

        return preferenceStack;
    }





}


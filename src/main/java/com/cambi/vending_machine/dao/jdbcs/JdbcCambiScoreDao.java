package com.cambi.vending_machine.dao.jdbcs;

import com.cambi.vending_machine.dao.interfaces.CambiScoreDao;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.product.ProductNutrient;
import com.cambi.vending_machine.model.product.ProductNutrientGroup;
import com.cambi.vending_machine.model.stack.Nutrient;
import com.cambi.vending_machine.model.stack.NutrientGroup;
import com.cambi.vending_machine.model.stack.NutrientRange;
import com.cambi.vending_machine.model.stack.PreferenceStack;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCambiScoreDao implements CambiScoreDao {
    private final JdbcTestDao testDao;

    public JdbcCambiScoreDao(JdbcTestDao testDao) {
        this.testDao = testDao;
    }

//    private final ProductDao productDao;
//    private final PreferenceStackDao preferenceStack;

//    public JdbcCambiScoreDao(ProductDao productDao, PreferenceStackDao preferenceStack) {
//        this.productDao = productDao;
//        this.preferenceStack = preferenceStack;
//    }

    @Override
    public double getCambiScore() {

        // get product
        Product product = testDao.getProduct(1);
        PreferenceStack preferenceStack = testDao.getPreferenceStack(1);

        // set cambi score to 0
        double cambiScore = 0;

        String[] nutrientGroups = {"macro", "micro", "ingredient"};
        for (String nutrientGroup : nutrientGroups) {
            NutrientGroup stackNutrientGroup = preferenceStack.getNutrientGroupByName(nutrientGroup);
            ProductNutrientGroup productNutrientGroup = product.getNutrientGroupByName(nutrientGroup);
            double nutrientScore = getNutrientScore(stackNutrientGroup, productNutrientGroup);
            cambiScore += nutrientScore * stackNutrientGroup.getWeight();
            System.out.println(nutrientGroup + " "+ nutrientScore);
        }

       return 10*cambiScore;
    }



    private double getNutrientScore(NutrientGroup nutrientGroup, ProductNutrientGroup productNutrientGroup) {
            List<ProductNutrient> productNutrients = productNutrientGroup.getProductNutrients();

            for (ProductNutrient productNutrient : productNutrients) {
                String nutrientName = productNutrient.getName();
                double nutrientAmount = productNutrient.getAmount();

                // Find the corresponding Nutrient in the NutrientGroup
                Nutrient nutrient = null;
                for (Nutrient n : nutrientGroup.getNutrients()) {
                    if (n.getName().equals(nutrientName)) {
                        nutrient = n;
                        break;
                    }
                }

                if (nutrient != null) {
                    // Find the corresponding NutrientRange for the nutrient amount
                    NutrientRange nutrientRange = null;
                    for (NutrientRange range : nutrient.getRanges()) {
                        if (nutrientAmount >= range.getMin() && nutrientAmount <= range.getMax()) {
                            nutrientRange = range;
                            break;
                        }
                    }

                    if (nutrientRange != null) {
                        System.out.println("get score " + nutrientRange.getScore());
                        return nutrientRange.getScore();
                    }
                }
            }

            return 0.0; // Return a default score if no range is found
        }


    }



package com.cambi.vending_machine.dao.jdbcs;

import com.cambi.vending_machine.dao.interfaces.CambiScoreDao;
import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.stack.Nutrient;
import com.cambi.vending_machine.model.stack.NutrientGroup;
import com.cambi.vending_machine.model.stack.NutrientRange;
import com.cambi.vending_machine.model.stack.PreferenceStack;


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
    public double GetCambiScore() {
        PreferenceStack preferenceStack = testDao.getPreferenceStack(1);
        Product product = testDao.getProduct(1);
        NutrientGroup macro = preferenceStack.getNutrientGroupByType("macro");
        System.out.println(macro.toString());

        double macroScore = 0.0;
        double sumScores = 0.0;

        if (macro != null) {
            for (Nutrient nutrient : macro.getNutrients()) {
                for (NutrientRange range : nutrient.getRanges()) {
                    // Check if the macro score falls within the range
                    if (macroScore >= range.getMin() && macroScore <= range.getMax()) {
                        // Add the score to the sumScores variable
                        sumScores += range.getScore();
                        // Break the loop since we found the matching range
                        break;
                    }
                }
            }
        }
        System.out.println(macroScore +  " " + sumScores);


        return 0;
    }






}

package com.cambi.vending_machine.dao.interfaces;

import com.cambi.vending_machine.model.product.Product;
import com.cambi.vending_machine.model.stack.PreferenceStack;

public interface TestDao {
    public int getTest();

    public Product getProduct(int productId);

    public PreferenceStack getPreferenceStack(int preferenceStackId);


}

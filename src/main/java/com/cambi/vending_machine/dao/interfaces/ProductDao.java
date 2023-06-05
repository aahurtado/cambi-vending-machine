package com.cambi.vending_machine.dao.interfaces;

import com.cambi.vending_machine.model.product.Product;

public interface ProductDao {
    public void addProduct (Product product);
    public Product getProduct (String gtinUpc);
    public void updateProduct(Product product);
    public void removeProduct(String gtinUpc);

}

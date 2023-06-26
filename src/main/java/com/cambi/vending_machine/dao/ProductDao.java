package com.cambi.vending_machine.dao;

import com.cambi.vending_machine.model.product.Product;

public interface ProductDao {

    void createProduct(Product product);
    Product getProductByUpc(String gtinUpc);
    void updateProduct(Product product);
    void deleteProductByUpc(String gtinUpc);
}

package com.cambi.vending_machine.controller;


import com.cambi.vending_machine.dao.NutrientDao;
import com.cambi.vending_machine.dao.ProductDao;
import com.cambi.vending_machine.model.Nutrient.Nutrient;
import com.cambi.vending_machine.model.product.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductDao productDao;

    ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct (@RequestBody Product product) {
        productDao.createProduct(product);
    }

    @GetMapping
    public Product getProduct (@RequestParam String gtinUpc) {
        return productDao.getProductByUpc(gtinUpc);
    }

    @PutMapping
    public void updateProduct (@RequestBody Product product) {
        productDao.updateProduct(product);
    }
    @DeleteMapping
    public void deleteProduct (@RequestParam String gtinUpc) {
        productDao.deleteProductByUpc(gtinUpc);
    }
}


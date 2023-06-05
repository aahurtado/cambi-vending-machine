package com.cambi.vending_machine.model.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String gtinUpc;
    private List<ProductNutrient> productNutrients = new ArrayList<>();
    private int productId;

    public Product () {}
    public Product (String gtinUpc, List<ProductNutrient> productNutrients, int productId) {
        this.gtinUpc = gtinUpc;
        this.productNutrients = productNutrients;
        this.productId = productId;
    }
    public String getGtinUpc() {
        return gtinUpc;
    }
    public List<ProductNutrient> getProductNutrients() {
        return productNutrients;
    }
    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }
    public void setProductNutrients(List<ProductNutrient> productNutrients) {
        this.productNutrients = productNutrients;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{")
                .append("gtinUpc='").append(gtinUpc).append('\'');

        if (!productNutrients.isEmpty()) {
            sb.append(", productNutrients=[");
            for (int i = 0; i < productNutrients.size(); i++) {
                sb.append(productNutrients.get(i).toString());
                if (i < productNutrients.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(']');
        }

        sb.append('}');
        return sb.toString();
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

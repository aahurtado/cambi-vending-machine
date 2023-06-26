package com.cambi.vending_machine.model.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
    private int productId;
    private String gtinUpc;
    private Date publicationDate;
    private Date modifiedDate;
    private String brandOwner;
    private String foodCategory;
    private String description;
    private String houseHoldServingFullText;
    private String servingSizeUnit;
    private BigDecimal servingSize;

    List<ProductNutrient> productNutrients = new ArrayList<>();

    public Product () {};
    public Product (int productId, String gtinUpc, Date publicationDate, Date modifiedDate,
                    String brandOwner, String foodCategory, String description, String houseHoldServingFullText,
                    String servingSizeUnit, BigDecimal ServingSize, List<ProductNutrient> productNutrients) {
        this.productId = productId;
        this.gtinUpc = gtinUpc;
        this. publicationDate = publicationDate;
        this.modifiedDate = modifiedDate;
        this.brandOwner = brandOwner;
        this.foodCategory = foodCategory;
        this.description = description;
        this.houseHoldServingFullText = houseHoldServingFullText;
        this.servingSizeUnit = servingSizeUnit;
        this.servingSize = ServingSize;
        this.productNutrients = productNutrients;

    }
    public String getGtinUpc() {
        return gtinUpc;
    }
    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public BigDecimal getServingSize() {
        return servingSize;
    }
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }
    public String getBrandOwner() {
        return brandOwner;
    }
    public String getDescription() {
        return description;
    }
    public String getFoodCategory() {
        return foodCategory;
    }
    public String getHouseHoldServingFullText() {
        return houseHoldServingFullText;
    }
    public String getServingSizeUnit() {
        return servingSizeUnit;
    }
    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }
    public void setHouseHoldServingFullText(String houseHoldServingFullText) {
        this.houseHoldServingFullText = houseHoldServingFullText;
    }
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setServingSize(BigDecimal servingSize) {
        this.servingSize = servingSize;
    }

    public void setServingSizeUnit(String servingSizeUnit) {
        this.servingSizeUnit = servingSizeUnit;
    }

    public List<ProductNutrient> getProductNutrients() {
        return productNutrients;
    }
    public void setProductNutrients(List<ProductNutrient> productNutrients) {
        this.productNutrients = productNutrients;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", gtinUpc='" + gtinUpc + '\'' +
                ", publicationDate=" + publicationDate +
                ", modifiedDate=" + modifiedDate +
                ", brandOwner='" + brandOwner + '\'' +
                ", foodCategory='" + foodCategory + '\'' +
                ", description='" + description + '\'' +
                ", houseHoldServingFullText='" + houseHoldServingFullText + '\'' +
                ", servingSizeUnit='" + servingSizeUnit + '\'' +
                ", servingSize=" + servingSize +
                '}';
    }
}



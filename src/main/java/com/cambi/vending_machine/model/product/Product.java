package com.cambi.vending_machine.model.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
    private int productId;
    private int fdcId;
    private String availableDate;
    private String brandOwner;
    private String dataSource;
    private String description;
    private String gtinUpc;
    private String householdServingFullText;
    private String ingredients;
    private String modifiedDate;
    private String publicationDate;
    private int servingSize;
    private String servingSizeUnit;
    private String brandedFoodCategory;

    // Constructors (optional)

    public Product() {
    }

    public Product(int productId, int fdcId, String availableDate, String brandOwner, String dataSource,
                   String description, String gtinUpc, String householdServingFullText, String ingredients,
                   String modifiedDate, String publicationDate, int servingSize, String servingSizeUnit,
                   String brandedFoodCategory) {
        this.productId = productId;
        this.fdcId = fdcId;
        this.availableDate = availableDate;
        this.brandOwner = brandOwner;
        this.dataSource = dataSource;
        this.description = description;
        this.gtinUpc = gtinUpc;
        this.householdServingFullText = householdServingFullText;
        this.ingredients = ingredients;
        this.modifiedDate = modifiedDate;
        this.publicationDate = publicationDate;
        this.servingSize = servingSize;
        this.servingSizeUnit = servingSizeUnit;
        this.brandedFoodCategory = brandedFoodCategory;
    }

    // Getters and Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGtinUpc() {
        return gtinUpc;
    }

    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    public String getHouseholdServingFullText() {
        return householdServingFullText;
    }

    public void setHouseholdServingFullText(String householdServingFullText) {
        this.householdServingFullText = householdServingFullText;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public String getServingSizeUnit() {
        return servingSizeUnit;
    }

    public void setServingSizeUnit(String servingSizeUnit) {
        this.servingSizeUnit = servingSizeUnit;
    }

    public String getBrandedFoodCategory() {
        return brandedFoodCategory;
    }

    public void setBrandedFoodCategory(String brandedFoodCategory) {
        this.brandedFoodCategory = brandedFoodCategory;
    }
}




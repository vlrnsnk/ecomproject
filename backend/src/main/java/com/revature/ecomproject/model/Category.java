package com.revature.ecomproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Category {

    private int categoryId;
    private String categoryName;
    private String image;         //Url for the picture
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Product> products; // One category has many products... someone who works on the product should add Product model


    public Category() {

    }

    public Category(int categoryId, String categoryName, String image, List<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.image = image;
        this.products = products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
            "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", image='" + image + '\'' +
            ", products=" + products +
            '}';
    }
}

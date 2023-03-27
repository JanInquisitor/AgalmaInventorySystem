package org.agalma.entities;

import java.util.ArrayList;

// This class represents the individual Items in store. It will be the data type of this system. (Or one of them at least)
public class ProductItem {
    private final String productId;
    private String productName;
    private double price;

    // I will have these two attribute/property as a boolean to compute just in time the discounted price if this bool is made true
    private boolean sale = false;
//    private int saleDiscountPercent; This line is a maybe

    private final ArrayList<String> ingredients = new ArrayList<String>();

    public ProductItem(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return productName;
    }
}

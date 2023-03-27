package org.agalma.entities;

import java.time.LocalDateTime;

public class InventoryItem {
    private final ProductItem product;
    private int quantity;
    private final LocalDateTime creationDate;
    private String location;


    // This class is used for keeping track and handling the products items in the inventory and its information,
    // but it will not alter them.
    public InventoryItem(ProductItem product, int quantity, LocalDateTime creationDate, String location) {
        this.product = product;
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.location = location;
    }

    // Getters and setters for the properties
    public ProductItem getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }


    @Override
    public String toString() {
        return "InventoryItem{" +
                "\n  product=" + product +
                "\n  quantity=" + quantity +
                "\n  location='" + location + '\'' +
                "\n}";
    }

}


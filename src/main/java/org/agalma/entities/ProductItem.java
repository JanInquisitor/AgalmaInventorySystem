package org.agalma.entities;

import java.time.LocalDateTime;

// This class is used for keeping track and handling the products items in the inventory and its information,
public class ProductItem extends Product {
    private String barcode;
    private double price;
    private int quantity;
    private final LocalDateTime creationDate;
    private String store;
    private int batchNumber = Integer.parseInt(null);

    public ProductItem(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        super(ISBN, name, sale);
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.store = store;
    }

    public ProductItem(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients) {
        super(ISBN, name, sale, ingredients);
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.store = store;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return store;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

}


package org.agalma.entities;

import java.time.LocalDateTime;

// This class is used for keeping track and handling the products items in the inventory and its information,
public class ProductItem extends Product {
    private final String barcode;
    private final double price;
    private int quantity;
    private final LocalDateTime creationDate;
    private final String store;

//    private int batchNumber = Integer.parseInt(null);

    public ProductItem(String GTIN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        super(GTIN, name, sale);
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.store = store;
    }

    public ProductItem(String GTIN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients) {
        super(GTIN, name, sale, ingredients);
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.creationDate = creationDate;
        this.store = store;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getStore() {
        return store;
    }
}


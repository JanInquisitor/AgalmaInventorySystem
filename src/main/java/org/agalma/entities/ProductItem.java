package org.agalma.entities;

import org.agalma.interfaces.IStorage;

import java.time.LocalDateTime;


// This class is used for keeping track and handling the products items in the inventory and its information,
public class ProductItem extends Product {
    private String barcode;
    private double price;
    private int quantity;
    private final LocalDateTime creationDate;
    private String store;

    public ProductItem(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        super(ISBN, name, sale);
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


    // This method will be used for when the item is transfer to another storage.
    public void transfer(IStorage storage) {

    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "barcode='" + barcode + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", creationDate=" + creationDate +
                ", store='" + store + '\'' +
                '}';
    }
}


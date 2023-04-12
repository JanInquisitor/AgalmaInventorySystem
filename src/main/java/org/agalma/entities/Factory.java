package org.agalma.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


// Factory and storage are the main bulk of the application.
public class Factory extends Storage {
    @Override
    public ProductItem searchByName(String name) {
        return null;
    }

    @Override
    public ProductItem searchByCode(int code) {
        return null;
    }

    @Override
    public ProductItem searchByDate(LocalDate additionDate) {
        return null;
    }

    @Override
    public ArrayList<ProductItem> getStoredItems() {
        return null;
    }

    @Override
    public void addItem(ProductItem item) {

    }

    @Override
    public void addItem(String GTIN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {

    }

    @Override
    public void addItems(List<ProductItem> item) {

    }

    @Override
    public void addItems(ProductItem[] items) {

    }

    // @TODO: Implement this factory method.
    @Override
    public Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        return null;
    }

    // @TODO: Implement this factory method.
    @Override
    public Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients) {
        return null;
    }

}

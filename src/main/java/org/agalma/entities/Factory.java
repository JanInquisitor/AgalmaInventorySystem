package org.agalma.entities;

import org.agalma.interfaces.IStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// Factory and storage are the main bulk of the application.
public class Factory implements IStorage {
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
    public void addItems(List<ProductItem> item) {

    }

    @Override
    public void addItems(ProductItem[] items) {

    }
}

package org.agalma.entities;

import org.agalma.interfaces.IStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factory implements IStorage {
    @Override
    public List<ProductItem> searchByName(String name) {
        return null;
    }

    @Override
    public List<ProductItem> searchByCode(int code) {
        return null;
    }

    @Override
    public List<ProductItem> searchByDate(LocalDate additionDate) {
        return null;
    }

    @Override
    public ArrayList<InventoryItem> getStoredItems() {
        return null;
    }

    @Override
    public void addItem(InventoryItem item) {

    }

    @Override
    public void addItems(List<InventoryItem> item) {

    }
}

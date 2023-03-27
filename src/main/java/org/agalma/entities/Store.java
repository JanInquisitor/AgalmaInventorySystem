package org.agalma.entities;

import org.agalma.interfaces.IStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store implements IStorage {
    String name;
    String address; // Maybe make an address class

    private final ArrayList<InventoryItem> storedItems = new ArrayList<InventoryItem>();


    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    //
    @Override
    public void addItem(InventoryItem item) {
        storedItems.add(item);
    }

    @Override
    public void addItems(List<InventoryItem> items) {
        storedItems.addAll(items);
    }

    public ArrayList<InventoryItem> getStoredItems() {
        return storedItems;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

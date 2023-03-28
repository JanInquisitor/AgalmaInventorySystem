package org.agalma.entities;

import org.agalma.interfaces.IStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store implements IStorage {
    String name;
    String address; // Maybe make an address class

    private final ArrayList<ProductItem> storedItems = new ArrayList<ProductItem>();

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

    @Override
    public void addItem(ProductItem item) {
        storedItems.add(item);
    }

    @Override
    public void addItems(List<ProductItem> items) {
        storedItems.addAll(items);
    }

    @Override
    public void addItems(ProductItem[] items) {
        storedItems.addAll(Arrays.asList(items));
    }

    public ArrayList<ProductItem> getStoredItems() {
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

package org.agalma.interfaces;

import org.agalma.entities.ProductItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IStorage {
    public ProductItem searchByName(String name);

    public ProductItem searchByCode(int code);

    public ProductItem searchByDate(LocalDate additionDate);

    public ArrayList<ProductItem> getStoredItems();

    void addItem(ProductItem item);

    void addItems(List<ProductItem> item);

    void addItems(ProductItem[] items);

}
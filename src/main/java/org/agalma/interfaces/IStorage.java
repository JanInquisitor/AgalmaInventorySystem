package org.agalma.interfaces;

import org.agalma.entities.ProductItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IStorage {
    public List<ProductItem> searchByName(String name);

    public List<ProductItem> searchByCode(int code);

    public List<ProductItem> searchByDate(LocalDate additionDate);

    void addItem(ProductItem item);

    void addItems(List<ProductItem> item);

    void addItems(ProductItem[] items);

    public ArrayList<ProductItem> getStoredItems();

    //    public List<ProductItem> searchByStore(Store store);

}
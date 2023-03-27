package org.agalma.interfaces;

import org.agalma.entities.InventoryItem;
import org.agalma.entities.ProductItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IStorage {
    public List<ProductItem> searchByName(String name);

    public List<ProductItem> searchByCode(int code);

//    public List<ProductItem> searchByStore(Store store);

    public List<ProductItem> searchByDate(LocalDate additionDate);

    void addItem(InventoryItem item);

    void addItems(List<InventoryItem> item);


    public ArrayList<InventoryItem> getStoredItems();

}
package org.agalma.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Considering moving some methods to an interface.
public abstract class Storage {

    public abstract ProductItem searchByName(String name);

    public abstract ProductItem searchByCode(int code);

    public abstract ProductItem searchByDate(LocalDate additionDate);

    public abstract ArrayList<ProductItem> getStoredItems();

    public abstract void addItem(ProductItem item);

    public abstract void addItems(List<ProductItem> item);

    public abstract void addItems(ProductItem[] items);

    // Here products will be created with this factory method inherited from the storage parent abstract class.
    // This method don't always need to return a new instance, if there's already built instances then it will return
    // one of those.
    public abstract Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store);


    public abstract Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients);
}

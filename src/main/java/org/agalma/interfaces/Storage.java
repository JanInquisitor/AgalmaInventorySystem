package org.agalma.interfaces;

import org.agalma.entities.Product;
import org.agalma.entities.ProductItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Considering moving some methods to an interface.
public interface Storage {

    Product searchByName(String name);

    Product searchByCode(int code);

    Product searchByDate(LocalDate additionDate);

    ArrayList<ProductItem> getStoredItems();

    void addItem(ProductItem item);

    void addItem(String GTIN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store);

    void addItems(List<ProductItem> item);

    void addItems(ProductItem[] items);

    // This method don't always need to return a new instance, if there's already built instances then it will return
    // one of those.
    Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store);


    Product createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients);
}

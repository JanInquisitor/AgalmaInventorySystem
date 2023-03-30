package org.agalma.entities;

import org.agalma.interfaces.IStorage;
import org.jetbrains.annotations.NotNull;

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

    public int totalProductsQuantity() {
        int sum = 0;
        for (ProductItem item : storedItems)
            sum += item.getQuantity();
        return sum;
    }

    // This method will be used for when the item is transfer to another storage.
    // But now, should it just received the store object and the items to transfer.
    // On a later point in development this will be handled with the database instead of in memory storage.
    // Maybe could return a distinct object, like a Transfer object that will have a method that choose where to be transferred
    // and removing items to be transferred from this class list.

    // @TODO: Improve this method.
    // This is a temporal implementation.
    // It should probably change the store location property too.
    public void transferTo(@NotNull IStorage storage, ProductItem[] itemsToTransfer) {
        if (storedItems.size() != 0) {
            for (ProductItem currentItem : itemsToTransfer) {
                for (int j = 0; j < storedItems.size(); j++) {
                    if (storedItems.get(j).equals(currentItem)) {
                        storedItems.remove(storedItems.get(j));
                    }
                }
            }
            storage.addItems(itemsToTransfer);
        }
    }

    public Transfer makeTransferObject(ProductItem[] items) {
        return new Transfer(items);
    }

    @Override
    public ProductItem searchByName(String name) {
        for (ProductItem product : storedItems) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ProductItem searchByCode(int code) {
        for (ProductItem product : storedItems) {
            if (product.getProductISBN().equals(code)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ProductItem searchByDate(LocalDate additionDate) {
        for (ProductItem product : storedItems) {
            if (product.getProductName().equals(additionDate)) {
                return product;
            }
        }
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

    @Override
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

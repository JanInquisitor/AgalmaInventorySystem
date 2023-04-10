package org.agalma.entities;

import jdk.jshell.spi.ExecutionControl;
import org.agalma.services.printing.InventoryTablePrinter;
import org.agalma.utils.Transfer;
import org.jetbrains.annotations.NotNull;

import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Store extends Storage {
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
    public void transferTo(@NotNull Storage storage, ProductItem[] itemsToTransfer) {
        if (storedItems.size() == 0) {
            return;
        }
        for (ProductItem currentItem : itemsToTransfer) {
            storedItems.remove(currentItem);
        }
        storage.addItems(itemsToTransfer);
    }

    public Transfer makeTransferObject(ProductItem[] items) {
        return new Transfer(items);
    }

    public ProductItem searchByName(String name) {
        for (ProductItem product : storedItems) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public ProductItem searchByCode(int code) {
        for (ProductItem product : storedItems) {
            if (product.getProductGTIN().equals(code)) {
                return product;
            }
        }
        return null;
    }

    public ProductItem searchByDate(LocalDate additionDate) {
        for (ProductItem product : storedItems) {
            if (product.getProductName().equals(additionDate)) {
                return product;
            }
        }
        return null;
    }

    public void addItem(ProductItem item) {
        storedItems.add(item);
    }

    public void addItems(List<ProductItem> items) {
        storedItems.addAll(items);
    }

    public void addItems(ProductItem[] items) {
        storedItems.addAll(Arrays.asList(items));
    }

    public void generateInvoice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Method not yet implemented.");
    }

    public void printInventory(String inventorySource) {
        PrintService[] availablePrinters = PrinterJob.lookupPrintServices();
//        System.out.println(Arrays.toString(availablePrinters));

        InventoryTablePrinter printer = new InventoryTablePrinter(inventorySource);
        printer.print();
    }

    public void printInventory(String[][] inventorySource) {
        PrintService[] availablePrinters = PrinterJob.lookupPrintServices();
//        System.out.println(Arrays.toString(availablePrinters));

        InventoryTablePrinter printer = new InventoryTablePrinter(inventorySource);
        printer.print();
    }

    public ArrayList<ProductItem> getStoredItems() {
        return storedItems;
    }

    // @TODO: Implement this factory method.
    // Here products will be created with this factory method inherited from the storage parent abstract class.
    // This method don't always need to return a new instance, if there's already built instances then it will return
    // one of those.
    @Override
    public ProductItem createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        return new ProductItem(ISBN, name, sale, barcode, price, quantity, creationDate, store);
    }

    // @TODO: Implement this factory method.
    @Override
    public ProductItem createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients) {
        return new ProductItem(ISBN, name, sale, barcode, price, quantity, creationDate, store, ingredients);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

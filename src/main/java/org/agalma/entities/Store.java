package org.agalma.entities;

import jdk.jshell.spi.ExecutionControl;
import org.agalma.data.DatabaseConnection;
import org.agalma.interfaces.Storage;
import org.agalma.services.printing.InventoryTablePrinter;
import org.agalma.types.Address;
import org.agalma.utils.Transfer;
import org.jetbrains.annotations.NotNull;

import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Store implements Storage {
    String name;
    String address;

    // This list should probably check the database to see if there are stored items linked to this particular store.
    private final ArrayList<ProductItem> storedItems;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.storedItems = new ArrayList<>();
    }

    @Override
    public ProductItem createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        ProductItem product = null;
        for (ProductItem item : storedItems) {
            if (item.getProductName().equals(name)) {
                product = item;
            }
        }
        if (product == null) {
            product = new ProductItem(ISBN, name, sale, barcode, price, quantity, creationDate, store);
            storedItems.add(product);
        }
        return product;
    }

    @Override
    public ProductItem createProduct(String ISBN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store, String[] ingredients) {
        ProductItem product = null;
        for (ProductItem item : storedItems) {
            if (item.getProductName().equals(name)) {
                product = item;
            }
        }
        if (product == null) {
            product = new ProductItem(ISBN, name, sale, barcode, price, quantity, creationDate, store, ingredients);
            storedItems.add(product);
        }
        storedItems.add(product);
        return product;
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
            if (product.getProductGTIN().equals(code)) {
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
    public void addItem(String GTIN, String name, boolean sale, String barcode, double price, int quantity, LocalDateTime creationDate, String store) {
        ProductItem product = new ProductItem(
                GTIN,
                name,
                sale,
                barcode,
                price,
                quantity,
                creationDate,
                store
        );
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


    public void addItems(List<ProductItem> items) {
        storedItems.addAll(items);
    }

    public void addItems(ProductItem[] items) {
        storedItems.addAll(Arrays.asList(items));
    }

    public void generateInvoice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Method not yet implemented.");
    }

    private void populateStoredItemsList() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Method not yet implemented.");
    }

    public ArrayList<ProductItem> getStoredItems() {
        return storedItems;
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

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

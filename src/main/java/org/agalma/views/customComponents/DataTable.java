package org.agalma.views.customComponents;

import org.agalma.entities.ProductItem;
import org.agalma.entities.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataTable extends JTable {
    private String[] columnNames = { // this will be in its table class component to unclutter this class.
            "GTIN",
            "Name",
            "sale",
            "barcode",
            "price",
            "available",
            "Created",
            "Store_location"
    };
    private List<ProductItem> cache; // I will extract this to its own class with its table

    public DataTable(List<ProductItem> items) {
        this.setName("Product_Table");

        populateProductTable(items);
    }


    public DataTable() {
        this.setName("Product_Table");

        List<ProductItem> items = getProducts();
        populateProductTable(items);
    }

    // @TODO: Make this method get the products from a Data source.
    private List<ProductItem> getProducts() {
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");

        ProductItem bodyLotion = blueMall.createProduct(
                "852395",
                "Locion corporal",
                false,
                "sample_barcode",
                456,
                7,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem soap = blueMall.createProduct(
                "2344586",
                "Jabon Cielo",
                false,
                "sample_barcode",
                275,
                116,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem goatMilkSoap = blueMall.createProduct(
                "62313",
                "Jabon Leche de cabra.",
                false,
                "sample_barcode",
                300,
                49,
                LocalDateTime.now(),
                "Punta cana");

        ProductItem mintSoap = blueMall.createProduct(
                "6341367",
                "Jabon menta.",
                false,
                "sample_barcode",
                275,
                71,
                LocalDateTime.now(),
                "Punta cana");


        // Create an Array of ProductItems and add it to the store.
        List<ProductItem> productsList = new ArrayList<>();
        productsList.add(bodyLotion);
        productsList.add(soap);
        productsList.add(mintSoap);

        return productsList;
    }


    public void populateProductTable(List<ProductItem> items) {

        Object[][] data = new Object[items.size()][];

        for (int i = 0; i < items.size(); i++) {
            ProductItem item = items.get(i);
            data[i] = new Object[]{
                    item.getProductGTIN(),
                    item.getProductName(),
                    false,
                    item.getBarcode(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getCreationDate(),
                    item.getStore()
            };
        }

//        DataTable dataTable = new DataTable();
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        this.setModel(tableModel);
        cache = items;
    }

    public List<ProductItem> getCache() {
        return this.cache;
    }
}

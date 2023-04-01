package org.agalma;


import org.agalma.entities.Product;
import org.agalma.entities.Store;
import org.agalma.entities.ProductItem;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Create  stores
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");
        Store puntaCana = new Store("Punta Cana", "Blue mall Punta cana.");

        // Create items
        ProductItem bodyLotion = blueMall.createProduct(
                "852395",
                "Locion corporal",
                false,
                "sample_barcode",
                456,
                50,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem soap = blueMall.createProduct("2344586",
                "Jabon Cielo",
                false,
                "sample_barcode",
                275,
                400,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem goatMilkSoap = blueMall.createProduct("62313",
                "Jabon Leche de cabra.",
                false,
                "sample_barcode",
                300,
                49,
                LocalDateTime.now(),
                "Punta cana");

        ProductItem mintSoap = blueMall.createProduct("6341367",
                "Jabon menta.",
                false,
                "sample_barcode",
                275,
                71,
                LocalDateTime.now(),
                "Punta cana");


        // Create an Array of ProductItems and add it to the store.
        ProductItem[] firstItemsArray = {bodyLotion, soap, goatMilkSoap, mintSoap};
        blueMall.addItems(firstItemsArray);
        ProductItem[] secondItemArray = {bodyLotion, soap};

        // Testing transfer
        System.out.println("Blue mall storage: " + blueMall.getStoredItems());
        System.out.println("Punta cana storage: " + puntaCana.getStoredItems());
        blueMall.transferTo(puntaCana, secondItemArray);
        System.out.println("=== After transfer ===");
        System.out.println("Blue mall storage: " + blueMall.getStoredItems());
        System.out.println("Punta cana storage: " + puntaCana.getStoredItems());

        // Testing Store functionalities
        System.out.println(blueMall.searchByName("Jabon Cielo"));
        System.out.println(blueMall.totalProductsQuantity());

    }

}
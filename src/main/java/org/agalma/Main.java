package org.agalma;

import org.agalma.data.DatabaseConnection;
import org.agalma.entities.Store;
import org.agalma.entities.ProductItem;

import java.awt.print.PrinterException;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) throws PrinterException {

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


        ProductItem mintSoapTwo = blueMall.createProduct(
                "16284",
                "Jabon menta.",
                false,
                "sample_barcode",
                275,
                71,
                LocalDateTime.now(),
                "Punta cana");

        ProductItem mintSoapThree = blueMall.createProduct(
                "8282",
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
        System.out.println("Stored items in blue mall: " + blueMall.totalProductsQuantity());


        String url = "jdbc:postgresql://localhost/fishnetdb";
        String user = "postgres";
        String password = "admin";

        DatabaseConnection conn = new DatabaseConnection(url, user, password);
//        conn.connect();
        int count = conn.getActorCount();
        System.out.println(count);


    }

}
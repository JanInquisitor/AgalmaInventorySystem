package org.agalma;


import org.agalma.entities.Store;
import org.agalma.entities.InventoryItem;
import org.agalma.entities.ProductItem;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // First I create products
        ProductItem rosehipSoap = new ProductItem("18sad7as7f2h2", "Jabón de Rosa de Mosqueta", 400);
        ProductItem lavenderSoap = new ProductItem("3243ffsdfs", "Jabon de Lavanda", 375);
        ProductItem mintSoap = new ProductItem("3243f24fs", "Jabon de menta", 375);
        ProductItem goatMilkSoap = new ProductItem("451ffe2fs", "Jabon de leche de cabra", 375);

        // Second I create the Inventory item objects that will hold information of the products in each inventory
        InventoryItem firstItem = new InventoryItem(rosehipSoap, 500, LocalDateTime.now(), "BlueMall");
        InventoryItem secondItem = new InventoryItem(lavenderSoap, 300, LocalDateTime.now(), "BlueMall");
        InventoryItem thirdItem = new InventoryItem(mintSoap, 300, LocalDateTime.now(), "BlueMall");
        InventoryItem fourthItem = new InventoryItem(goatMilkSoap, 300, LocalDateTime.now(), "BlueMall");

        // Create  store
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");

        InventoryItem[] items = {firstItem, secondItem, thirdItem, fourthItem};

        blueMall.addItems(List.of(items));
        System.out.println(blueMall);
        System.out.println(blueMall.getStoredItems());


    }

}
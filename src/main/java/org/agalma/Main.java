package org.agalma;


import org.agalma.entities.Product;
import org.agalma.entities.Store;
import org.agalma.entities.ProductItem;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Create items
        ProductItem firstItem = new ProductItem("8245195", "Jabon Rosa de Mosqueta", false, "sample_barcode", 375, 300, LocalDateTime.now(), "Blue mall");

        // Create  store
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");

//        ProductItem[] items = {firstItem, secondItem, thirdItem, fourthItem};

//        blueMall.addItems(List.of(items));
        System.out.println(blueMall);
        System.out.println(blueMall.getStoredItems());


    }

}
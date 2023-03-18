package org.agalma;


import entities.Store;
import items.InventoryItem;
import items.SkinProduct;
import utils.RandomString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        SkinProduct soap = new SkinProduct("18sad7as7f2h2", "Jabon de Rosa de Mosqueta", 400);

        InventoryItem firstItem = new InventoryItem(soap, 500, LocalDateTime.now(), "BlueMall");

        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");

        System.out.println(blueMall);
    }

}
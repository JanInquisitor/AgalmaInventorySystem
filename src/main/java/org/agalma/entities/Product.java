package org.agalma.entities;

import java.util.ArrayList;

// This class represents the individual Items in store. It will be the data type of this system. (Or one of them at least)
public abstract class Product {
    private String ISBN;
    private final String name;
    private boolean sale;
    private final ArrayList<String> ingredients = new ArrayList<String>();

    public Product(String ISBN, String name, boolean sale) {
        this.ISBN = ISBN;
        this.name = name;
        this.sale = sale;
    }

    public String getProductISBN() {
        return ISBN;
    }

    public String getProductName() {
        return name;
    }

    public void addIngredient(String ingredient) {

    }

}

package org.agalma.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// This class represents the individual Items in store. It will be the data type of this system. (Or one of them at least)
public abstract class Product {
    private String ISBN;
    private final String name;
    private boolean sale;
    private final String[] ingredients;


    public Product(String ISBN, String name, boolean sale) {
        this.ISBN = ISBN;
        this.name = name;
        this.sale = sale;
        this.ingredients = null;
    }

    public Product(String ISBN, String name, boolean sale, String[] ingredients) {
        this.ISBN = ISBN;
        this.name = name;
        this.sale = sale;
        this.ingredients = ingredients;
    }


    public String getProductISBN() {
        return ISBN;
    }

    public String getProductName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return ISBN.equals(product.ISBN) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

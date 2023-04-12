package org.agalma.entities;

import java.util.Objects;

public abstract class Product {
    private String GTIN;
    private final String name;
    private String description;
    private boolean sale;
    private final String[] ingredients;


    public Product(String GTIN, String name, boolean sale) {
        this.GTIN = GTIN;
        this.name = name;
        this.sale = sale;
        this.ingredients = null;
    }

    public Product(String ISBN, String name, boolean sale, String[] ingredients) {
        this.GTIN = ISBN;
        this.name = name;
        this.sale = sale;
        this.ingredients = ingredients;
    }

    public String getProductGTIN() {
        return GTIN;
    }

    public String getProductName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return GTIN.equals(product.GTIN) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GTIN, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "GTIN='" + GTIN + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}

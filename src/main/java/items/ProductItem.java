package items;

import entities.Store;

import java.util.ArrayList;
import java.util.List;

// This class represents the individual Items in store. It will be the data type of this system. (Or one of them at least)
public class ProductItem {
    private String productId;
    private String productName;
    private double price;
    private Store store;

    private final ArrayList<String> ingredients = new ArrayList<String>();

    public ProductItem(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public double getTotalPrice() {
//        return price * quantity;
//    }
//
//    public void updateQuantity(int newQuantity) {
//        this.quantity = newQuantity;
//    }
}

package items;

import java.time.LocalDateTime;

public class InventoryItem {
    private ProductItem product;
    private int quantity;
    private LocalDateTime lastUpdated;
    private String location;

    // This class is used for keeping track and handling the products items in the inventory but it will not alter them
    public InventoryItem(ProductItem product, int quantity, LocalDateTime lastUpdated, String location) {
        this.product = product;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
        this.location = location;
    }

    // Getters and setters for the properties
    public ProductItem getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}


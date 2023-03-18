package interfaces;

import entities.Store;
import items.InventoryItem;
import items.ProductItem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IStorage {
    public List<items.ProductItem> searchByName(String name);

    public List<items.ProductItem> searchByCode(int code);

    public List<items.ProductItem> searchByStore(Store store);

    public List<items.ProductItem> searchByDate(LocalDate additionDate);

    public void addItem(ProductItem item);
}
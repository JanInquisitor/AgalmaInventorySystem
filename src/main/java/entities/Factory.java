package entities;

import interfaces.IStorage;
import items.ProductItem;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Factory implements IStorage {
    @Override
    public List<ProductItem> searchByName(String name) {
        return null;
    }

    @Override
    public List<ProductItem> searchByCode(int code) {
        return null;
    }

    @Override
    public List<ProductItem> searchByStore(Store store) {
        return null;
    }

    @Override
    public List<ProductItem> searchByDate(LocalDate additionDate) {
        return null;
    }

    @Override
    public void addItem(ProductItem item) {

    }
}

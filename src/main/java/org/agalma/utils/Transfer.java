package org.agalma.utils;


import org.agalma.entities.ProductItem;
import org.agalma.interfaces.Storage;

// If transfering becomes more complicated I'll consider making it an interface.
public class Transfer {

    private ProductItem[] items;

    public Transfer(ProductItem[] items) {
        this.items = items;
    }

    // @TODO: Implement the transfer logic here
    public void transferTo(Storage storage) {

    }
}

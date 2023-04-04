package org.agalma.entities;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String customerName;
    private String customerAddress;
    private Date invoiceDate;
    private int invoiceNumber;
    private List<Product> itemsPurchased;

    public Invoice(String customerName, String customerAddress, Date invoiceDate, int invoiceNumber, List<Product> itemsPurchased) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.itemsPurchased = itemsPurchased;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public List<Product> getItemsPurchased() {
        return itemsPurchased;
    }
}

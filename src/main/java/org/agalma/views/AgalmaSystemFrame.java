package org.agalma.views;

import org.agalma.entities.ProductItem;
import org.agalma.entities.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

public class AgalmaSystemFrame extends JFrame {
    private JPanel panelMain;
    private JTable productTable;
    private JButton addItemBtn;
    private JScrollPane scrollTablePanel;
    private JPanel sidePanel;
    private JButton invoiceButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    ItemCreationModal itemCreationModal;

    public AgalmaSystemFrame() {
        super("Agalma");

        // Application Main Frame Configuration Settings
        configuration();

        // Initializing components
        initComponents();

        setVisible(true);

    }

    private void configuration() {
        setName("SQLite Viewer");
        setResizable(true);
        setLocationRelativeTo(null);
        setContentPane(panelMain);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    // @TODO: Modify this method, generateProduct method and the whole class to make a decent table mechanism. The current state of this class is just for testing for now.
    public void populateProductTable() {
        String[] columnNames = {
                "GTIN",
                "Name",
                "sale",
                "barcode",
                "price",
                "available",
                "Created",
                "Store_location"
        };
        // Data
        ProductItem[] items = generateProducts();
        Object[][] data = new Object[items.length][];

        for (int i = 0; i < items.length; i++) {
            ProductItem item = items[i];
            data[i] = new Object[]{
                    item.getProductGTIN(),
                    item.getProductName(),
                    false,
                    item.getBarcode(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getCreationDate(),
                    item.getStore()
            };
        }

//        DataTable dataTable = new DataTable();
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        productTable.setModel(tableModel);
        productTable.setName("Product_Table");

    }

    public void updateTable(ProductItem item) {
        String[] columnNames = {
                "GTIN",
                "Name",
                "sale",
                "barcode",
                "price",
                "available",
                "Created",
                "Store_location"
        };

        ProductItem[] itemsArr = generateProducts();

        // Create a new Object[][] array with one additional row for the new item
        Object[][] updatedData = new Object[itemsArr.length + 1][columnNames.length];

        // Copy data from the existing itemsArr into updatedData
        for (int i = 0; i < itemsArr.length; i++) {
            updatedData[i] = new Object[]{
                    itemsArr[i].getProductGTIN(),
                    itemsArr[i].getProductName(),
                    false,
                    itemsArr[i].getBarcode(),
                    itemsArr[i].getPrice(),
                    itemsArr[i].getQuantity(),
                    itemsArr[i].getCreationDate(),
                    itemsArr[i].getStore()
            };
        }

        // Add the new item to the last row of updatedData
        updatedData[itemsArr.length] = new Object[]{
                item.getProductGTIN(),
                item.getProductName(),
                false,
                item.getBarcode(),
                item.getPrice(),
                item.getQuantity(),
                item.getCreationDate(),
                item.getStore()
        };

        DefaultTableModel tableModel = new DefaultTableModel(updatedData, columnNames);
        productTable.setModel(tableModel);
    }



    private ProductItem[] generateProducts() {
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");

        ProductItem bodyLotion = blueMall.createProduct(
                "852395",
                "Locion corporal",
                false,
                "sample_barcode",
                456,
                7,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem soap = blueMall.createProduct(
                "2344586",
                "Jabon Cielo",
                false,
                "sample_barcode",
                275,
                116,
                LocalDateTime.now(),
                "Blue mall");

        ProductItem goatMilkSoap = blueMall.createProduct(
                "62313",
                "Jabon Leche de cabra.",
                false,
                "sample_barcode",
                300,
                49,
                LocalDateTime.now(),
                "Punta cana");

        ProductItem mintSoap = blueMall.createProduct(
                "6341367",
                "Jabon menta.",
                false,
                "sample_barcode",
                275,
                71,
                LocalDateTime.now(),
                "Punta cana");


        // Create an Array of ProductItems and add it to the store.
        ProductItem[] productsArray = {bodyLotion, soap, goatMilkSoap, mintSoap};

        return productsArray;
    }

    private void initComponents() {
        populateProductTable();
        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the product entry form when the "Open" button is clicked
                if (itemCreationModal == null) {
                    itemCreationModal = new ItemCreationModal(AgalmaSystemFrame.this);
                    itemCreationModal.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // Set the itemCreationModal reference to null when the modal is closed
                            itemCreationModal = null;
                        }
                    });
                } else {
                    // If the form is already open, bring it to the front
                    itemCreationModal.toFront();
                }
                // Ensure the modal is visible
                itemCreationModal.setVisible(true);
            }
        });
    }
}

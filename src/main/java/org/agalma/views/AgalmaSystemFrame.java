package org.agalma.views;

import org.agalma.entities.ProductItem;
import org.agalma.entities.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AgalmaSystemFrame extends JFrame {
    private JPanel panelMain;
    private JTable productTable;
    private JButton addItemBtn;
    private JScrollPane scrollTablePanel;
    private JPanel sidePanel;
    private JButton invoiceButton;

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
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(panelMain);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    public void initProductTable() {
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

    private ProductItem[] generateProducts() {
        Store blueMall = new Store("Blue Mall", "Av. Winston Churchill.");
        Store puntaCana = new Store("Punta Cana", "Blue mall Punta cana.");

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


        ProductItem mintSoapTwo = blueMall.createProduct(
                "16284",
                "Jabon menta.",
                false,
                "sample_barcode",
                275,
                71,
                LocalDateTime.now(),
                "Punta cana");

        ProductItem mintSoapThree = blueMall.createProduct(
                "8282",
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
        initProductTable();
        addItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the product entry form when the "Open" button is clicked
                if (itemCreationModal == null) {
                    itemCreationModal = new ItemCreationModal();
                } else {
                    // If the form is already open, bring it to the front
                    itemCreationModal.toFront();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

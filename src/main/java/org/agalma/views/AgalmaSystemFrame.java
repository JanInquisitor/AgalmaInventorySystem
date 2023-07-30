package org.agalma.views;

import org.agalma.entities.ProductItem;
import org.agalma.entities.Store;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AgalmaSystemFrame extends JFrame implements ActionListener {

    JTable productTable;

    JTextField productInputField;

    JButton addButton;

    JButton searchButton;

    public AgalmaSystemFrame() {
        super("Agalma");

        // Application Main Frame Configuration Settings
        setName("SQLite Viewer");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Initializing components
        initComponents();

        setVisible(true);
    }

    void initComponents() {

        // Product table
        initProductTable();
    }

    public void initProductTable() {
        String[] columnNames = {
                "ISBN",
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
                    item.getPrice(),
                    item.getQuantity(),
                    item.getCreationDate(),
                    item.getStore()
            };
        }


        DataTable dataTable = new DataTable();
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        productTable = new JTable(tableModel);
        productTable.setName("Product_Table");
        Border titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Bold line
                "Table Title", // Title text
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font(Font.SANS_SERIF, Font.PLAIN, 12), // Bold font
                Color.BLACK
        );
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBounds(25, 10, 650, 200);
        scrollPane.setBorder(titledBorder);
        scrollPane.setBackground(Color.LIGHT_GRAY);
        add(scrollPane);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

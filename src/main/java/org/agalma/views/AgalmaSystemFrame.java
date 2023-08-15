package org.agalma.views;

import org.agalma.entities.ProductItem;
import org.agalma.views.customComponents.DataTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class AgalmaSystemFrame extends JFrame {
    private JPanel panelMain;
    private JScrollPane scrollTablePanel; // This is being used for the Table panel
    private DataTable dataTable;
    private JPanel sidePanel;
    private JButton addItemBtn;
    private JButton invoiceButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private List<ProductItem> cache; // I will extract this to its own class with its table

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


    public void updateTable(ProductItem item) {
        List<ProductItem> newList = new ArrayList<>(dataTable.getCache());
        newList.add(item);
        dataTable.populateProductTable(newList);
    }

    private void initComponents() {
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        dataTable = new DataTable();
    }
}

package org.agalma.views;

import javax.swing.*;
import java.awt.*;

public class ItemCreationModal extends JFrame {
    private JPanel panel1;
    private JTextField testTextField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField1;

    public ItemCreationModal() {

        configuration();

        setVisible(true);
    }

    private void configuration() {
        setName("SQLite Viewer");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    private void initComponents() {

    }
}

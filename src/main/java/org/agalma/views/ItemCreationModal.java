package org.agalma.views;

import javax.swing.*;
import java.awt.*;

public class ItemCreationModal extends JFrame {
    public ItemCreationModal() {
        configuration();
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

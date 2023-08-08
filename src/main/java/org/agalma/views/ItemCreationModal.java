package org.agalma.views;

import org.agalma.entities.Product;
import org.agalma.entities.ProductItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ItemCreationModal extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField nameTextfield;
    private JTextField descriptionTextField;
    private JTextField codeTextField;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel codeLabel;
    private JButton confirmBtn;

    public ItemCreationModal() {
        // Initialization code here (if needed)
        configuration();
        initListeners();
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Dispose the window when it is closed
//                dispose();
//            }
//        });
    }

    private void initListeners() {
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = getNameTextFieldValue();
                String description = getDescriptionTextFieldValue();
                String code = getCodeTextFieldValue();

                ProductItem item = new ProductItem(
                        "852395",
                        name,
                        false,
                        code,
                        456,
                        7,
                        LocalDateTime.now(),
                        "Blue mall");

                System.out.println(name);
                System.out.println(description);
                System.out.println(code);
            }
        });
    }

    private void configuration() {
        setName("SQLite Viewer");
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(350, 275);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    public String getNameTextFieldValue() {
        return nameTextfield.getText();
    }

    public String getDescriptionTextFieldValue() {
        return descriptionTextField.getText();
    }

    public String getCodeTextFieldValue() {
        return codeTextField.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Pressed!");
        System.out.println(e);
    }
}

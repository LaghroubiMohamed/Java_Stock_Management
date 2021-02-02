package pages;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import Listners.AddProduct.Add_product_save_button;
import Listners.Navigations.Back_to_Decision;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddProduct extends JFrame {

    private static final long serialVersionUID = 1L;
    public JTextField productNameField;
    public JTextField descriptionField;
    public JTextField quantiteField;
    public JTextField dateField;
    public JTextField prixField;



    public AddProduct() throws IOException {
        setTitle(" Stock Managements ");
        // make the frame half the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width / 2, height / 2);
        toBack();

        // center the jframe on screen
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);


        // add product title
        JLabel addTitle = new JLabel(" Add Product ");
        addTitle.setBounds(370, 20, 100, 30);
        getContentPane().add(addTitle);
        addTitle.setForeground(Color.blue);
        addTitle.setVisible(true);

        JLabel productName = new JLabel("Product Name");
        productName.setBounds(120, 90, 100, 30);
        getContentPane().add(productName);
        productName.setForeground(Color.black);
        setVisible(true);

        productNameField = new JTextField();
        productNameField.setBounds(280, 90, 150, 30);
        getContentPane().add(productNameField);
        productNameField.setVisible(true);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(120, 150, 100, 30);
        getContentPane().add(descriptionLabel);
        descriptionLabel.setForeground(Color.black);
        setVisible(true);

        descriptionField = new JTextField();
        descriptionField.setBounds(280, 150, 150, 30);
        getContentPane().add(descriptionField);
        descriptionField.setVisible(true);

        JLabel quantitéLabel = new JLabel("Quantité");
        quantitéLabel.setBounds(120, 210, 100, 30);
        getContentPane().add(quantitéLabel);
        quantitéLabel.setForeground(Color.black);

        quantiteField = new JTextField();
        quantiteField.setBounds(280, 210, 150, 30);
        getContentPane().add(quantiteField);
        quantiteField.setVisible(true);
        //


        JLabel prixLabel = new JLabel("Prix");
        prixLabel.setBounds(120, 270, 100, 30);
        getContentPane().add(prixLabel);
        prixLabel.setForeground(Color.black);

        prixField = new JTextField();
        prixField.setBounds(280, 270, 150, 30);
        getContentPane().add(prixField);
        prixField.setVisible(true);

        //
        JLabel date_de_péremption = new JLabel("Date de Péremption");
        date_de_péremption.setBounds(120, 330, 120, 30);
        getContentPane().add(date_de_péremption);
        date_de_péremption.setForeground(Color.black);
        setVisible(true);

        dateField = new JTextField();
        dateField.setBounds(280, 330, 150, 30);
        getContentPane().add(dateField);
        //get today date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        dateField.setText(dtf.format(now));
        dateField.setVisible(true);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(650, 340, 90, 25);
        clearButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(clearButton);
        clearButton.setBackground(Color.red);
        clearButton.addActionListener(e -> {
            productNameField.setText("");
            descriptionField.setText("");
            quantiteField.setText("");
            dateField.setText("");
        });

        JButton saveButton = new JButton("save");
        saveButton.setBounds(550, 340, 80, 25);
        saveButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(saveButton);
        saveButton.setBackground(Color.green);
        saveButton.addActionListener(new Add_product_save_button(this));

        JButton backButton = new JButton("< Back");
        backButton.setBounds(10, 10, 100, 25);
        backButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(backButton);
        backButton.setBackground(Color.lightGray);
        backButton.addActionListener(new Back_to_Decision(this));

    }
}

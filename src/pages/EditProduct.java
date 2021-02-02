package pages;

import Listners.Navigations.Back_to_Decision;
import Listners.EditProduct.Delete_Product;
import Listners.EditProduct.Edit_Product_Action;
import Listners.EditProduct.Search_Product;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class EditProduct extends JFrame {


    private static final long serialVersionUID = 1L;
    public JTextField nameField;
    public JTextField descriptionField;
    public JTextField quantiteField;
    public JTextField priceField;
    public JTextField addQuantiteField;

    public EditProduct() throws IOException {
        setTitle(" Edit Products Info ");
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

        // Edit product title
        JLabel addTitle = new JLabel(" Edit Your Products Here ");
        addTitle.setBounds(370, 20, 200, 30);
        getContentPane().add(addTitle);
        addTitle.setForeground(Color.blue);
        addTitle.setVisible(true);

        // how edit user msg
        JLabel editInfo = new JLabel("After making a search you can easily edit the product info.");
        editInfo.setBounds(290, 40, 450, 30);
        getContentPane().add(editInfo);
        editInfo.setForeground(Color.blue);
        editInfo.setVisible(true);
        //edit Qant msg
        JLabel editQant = new JLabel("And you can also add a new quantite or just edited manually");
        editQant.setBounds(500, 180, 450, 30);
        getContentPane().add(editQant);
        editQant.setForeground(Color.red);
        editQant.setVisible(true);



        JLabel productNameLabel = new JLabel("Product Name");
        productNameLabel.setBounds(270, 90, 100, 30);
        getContentPane().add(productNameLabel);
        productNameLabel.setForeground(Color.black);
        setVisible(true);

        nameField = new JTextField();
        nameField.setBounds(370, 90, 150, 30);
        getContentPane().add(nameField);
        nameField.setVisible(true);

        // search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(525, 90, 100, 25);
        searchButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(searchButton);
        searchButton.setBackground(Color.lightGray);
        searchButton.setForeground(Color.blue);
        searchButton.addActionListener(new Search_Product(this));

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(270, 150, 100, 30);
        getContentPane().add(descriptionLabel);
        descriptionLabel.setForeground(Color.black);
        setVisible(true);

        descriptionField = new JTextField();
        descriptionField.setBounds(370, 150, 150, 30);
        getContentPane().add(descriptionField);
        descriptionField.setVisible(true);

        JLabel quantityLabel = new JLabel("Quantity ");
        quantityLabel.setBounds(270, 210, 100, 30);
        getContentPane().add(quantityLabel);
        quantityLabel.setForeground(Color.black);

        quantiteField = new JTextField();
        quantiteField.setBounds(370, 210, 150, 30);
        getContentPane().add(quantiteField);
        quantiteField.setVisible(true);

        // addition sign
        JLabel plusLabel = new JLabel("+");
        plusLabel.setBounds(530, 210, 10, 30);
        getContentPane().add(plusLabel);
        plusLabel.setForeground(Color.black);

        //add quantite field
        addQuantiteField = new JTextField();
        addQuantiteField.setBounds(550, 210, 200, 30);
        getContentPane().add(addQuantiteField);
        addQuantiteField.setVisible(true);


        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(270, 270, 100, 30);
        getContentPane().add(priceLabel);
        priceLabel.setForeground(Color.black);
        setVisible(true);

        priceField = new JTextField();
        priceField.setBounds(370, 270, 150, 30);
        getContentPane().add(priceField);
        priceField.setVisible(true);

        JButton deleteButton = new JButton("Delete Product");
        deleteButton.setBounds(280, 350, 170, 25);
        deleteButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(deleteButton);
        deleteButton.setBackground(Color.red);
        deleteButton.addActionListener(new Delete_Product(this));

        JButton saveButton = new JButton("Save Edits");
        saveButton.setBounds(480, 350, 170, 25);
        saveButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(saveButton);
        saveButton.setBackground(Color.green);
        saveButton.addActionListener(new Edit_Product_Action(this));

        JButton backButton = new JButton("< Back");
        backButton.setBounds(10, 10, 100, 25);
        backButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(backButton);
        backButton.setBackground(Color.lightGray);
        backButton.addActionListener(new Back_to_Decision(this));

    }
}

package pages;

import Listners.Commande.Confirm_Command;
import Listners.Commande.Show_Facture;
import Listners.Navigations.Back_to_Decision;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;


public class Commande extends JFrame {
    public JTextField quantiteField;
    public JComboBox<String> productName;
    public JButton showFacture;
    public JLabel labelbordered;
    public JLabel factureProName;
    public JLabel productNameLabel;
    public JLabel factureProPrice;
    public JLabel productPrice;
    public JLabel factureProQuantity;
    public JLabel productQuantity;
    public JLabel factureTotalPrice;
    public JLabel priceToPay;
    public JButton passCommand;
    public String Qantityleft;
    public JTextField clientfield;
    public JLabel commandClient;
    public JLabel getCommandClient;


    public Commande(List<String> combodata){

        String[] mycombodata = combodata.toArray(new String[0]);
        setTitle(" Pass Your Command ");
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

        // Edit Command title
        JLabel addTitle = new JLabel(" Here You Can Pass Your Commands ");
        addTitle.setFont(new Font("fira code",1,15));
        addTitle.setBounds(360, 20, 300, 30);
        getContentPane().add(addTitle);
        addTitle.setForeground(Color.blue);
        addTitle.setVisible(true);

        //combobox
        productName = new JComboBox(mycombodata);
        productName.setBounds(160,100,250,30);
        productName.setForeground(new Color(64,64,64));
        getContentPane().add(productName);
        productName.setVisible(true);


        //
        JLabel prenomLabel = new JLabel("Quantité");
        prenomLabel.setBounds(160, 150, 80, 30);
        getContentPane().add(prenomLabel);
        prenomLabel.setForeground(Color.black);

        quantiteField = new JTextField();
        quantiteField.setBounds(230, 150, 180, 30);
        getContentPane().add(quantiteField);
        quantiteField.setVisible(true);

        //client field
        JLabel clientLabel = new JLabel("Client ");
        clientLabel.setBounds(160, 200, 80, 30);
        getContentPane().add(clientLabel);
        clientLabel.setForeground(Color.black);

        clientfield = new JTextField();
        clientfield.setBounds(230, 200, 180, 30);
        getContentPane().add(clientfield);
        clientfield.setVisible(true);



        showFacture = new JButton(" Show Facture ");
        showFacture.setBounds(230, 300, 180, 25);
        showFacture.setForeground(Color.black);
        showFacture.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(showFacture);
        showFacture.setBackground(new Color(255,153,153));
        showFacture.addActionListener(new Show_Facture(this));


        JButton backButton = new JButton("< Back");
        backButton.setBounds(10, 10, 100, 25);
        backButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(backButton);
        backButton.setBackground(Color.lightGray);
        backButton.addActionListener(new Back_to_Decision(this));

        //right label
        labelbordered = new JLabel();
        labelbordered.setBounds(450,100,440,400);
        Border border = BorderFactory.createLineBorder(new Color(255,204,204), 2);
        labelbordered.setBorder(border);
        getContentPane().add(labelbordered);
        labelbordered.setVisible(false);


        //Pass Command button
        passCommand = new JButton("Confirm");
        passCommand.setBounds(620, 420, 200, 25);
        passCommand.setVisible(false);
        getContentPane().add(passCommand);
        passCommand.setBackground(new Color(255,153,51));
        passCommand.addActionListener(new Confirm_Command(this));


        //facture fields
        //client
        commandClient = new JLabel("Client Name : ");
        commandClient.setBounds(550, 120, 120, 30);
        getContentPane().add(commandClient);
        commandClient.setForeground(new Color(128,128,128));
        commandClient.setVisible(false);


        getCommandClient = new JLabel("Tim");
        getCommandClient.setBounds(680, 120, 100, 30);
        getContentPane().add(getCommandClient);
        getCommandClient.setForeground(Color.black);
        getCommandClient.setVisible(false);

        //product names
        factureProName = new JLabel("Product name : ");
        factureProName.setBounds(550, 170, 120, 30);
        getContentPane().add(factureProName);
        factureProName.setForeground(new Color(128,128,128));
        factureProName.setVisible(false);


        productNameLabel = new JLabel("product 1");
        productNameLabel.setBounds(680, 170, 100, 30);
        getContentPane().add(productNameLabel);
        productNameLabel.setForeground(Color.black);
        productNameLabel.setVisible(false);

        //product price
         factureProPrice = new JLabel("Unite Price      : ");
        factureProPrice.setBounds(550, 220, 120, 30);
        getContentPane().add(factureProPrice);
        factureProPrice.setForeground(new Color(128,128,128));
        factureProPrice.setVisible(false);


        productPrice = new JLabel("12.99");
        productPrice.setBounds(680, 220, 100, 30);
        getContentPane().add(productPrice);
        productPrice.setForeground(Color.black);
        productPrice.setVisible(false);

        //product quantity
        factureProQuantity = new JLabel("Quantity          : ");
        factureProQuantity.setBounds(550, 270, 120, 30);
        getContentPane().add(factureProQuantity);
        factureProQuantity.setForeground(new Color(128,128,128));
        factureProQuantity.setVisible(false);

         productQuantity = new JLabel("400");
        productQuantity.setBounds(680, 270, 100, 30);
        getContentPane().add(productQuantity);
        productQuantity.setForeground(Color.black);
        productQuantity.setVisible(false);

        //total price
        factureTotalPrice = new JLabel("Total price       : ");
        factureTotalPrice.setBounds(550, 320, 120, 30);
        getContentPane().add(factureTotalPrice);
        factureTotalPrice.setForeground(new Color(128,128,128));
        factureTotalPrice.setVisible(false);

        priceToPay = new JLabel("5196 dh");
        priceToPay.setBounds(680, 320, 100, 30);
        getContentPane().add(priceToPay);
        priceToPay.setForeground(Color.black);
        priceToPay.setVisible(false);







    }



}

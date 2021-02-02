package Listners.EditProduct;

import Databases.SqlConnection;
import pages.EditProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Search_Product implements ActionListener {

    EditProduct editProduct;
    public Search_Product(EditProduct e) {
        editProduct =e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Connection connection = new SqlConnection().getConnection();
            String nameField = editProduct.nameField.getText().trim().toUpperCase();
            JTextField descriptionField = editProduct.descriptionField;
            JTextField quantiteField = editProduct.quantiteField;
            JTextField priceField = editProduct.priceField;
            JTextField addQuantityProductField = editProduct.addQuantiteField;



            String verifyProduct = "select * from products where productName =?";

            //verify if product is already exist from his name
            PreparedStatement preparedStatement = connection.prepareStatement(verifyProduct);
            preparedStatement.setString(1,nameField);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                //Todo: add message in screen user can see
                System.out.println("user is already exist");

                    int id = resultSet.getInt("id");
                    String productDesc = resultSet.getString("description");
                    String productQantite = resultSet.getString("quantite");
                    String productPrice = resultSet.getString("prix");

                    // print the results
                    System.out.format("%s, %s, %s, %s\n", id, productDesc, productQantite, productPrice);
                    descriptionField.setText(productDesc);
                    quantiteField.setText(productQantite);
                    priceField.setText(productPrice);
                    addQuantityProductField.setText("0");



            }else {
                    System.out.println("product is not exist");
                    descriptionField.setText("");
                    quantiteField.setText("");
                    priceField.setText("");


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

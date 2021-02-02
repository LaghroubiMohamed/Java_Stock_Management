package Listners.EditProduct;

import Databases.SqlConnection;
import pages.EditProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit_Product_Action implements ActionListener {

    EditProduct editProduct;

    public Edit_Product_Action(EditProduct e) {
        editProduct = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // get data from editProduct
        String productName = editProduct.nameField.getText().trim().toUpperCase();
        String productDesc = editProduct.descriptionField.getText().trim().toLowerCase();
        String productQantite = editProduct.quantiteField.getText().trim();
        String productPrice = editProduct.priceField.getText().trim();
        String addProductQantity= editProduct.addQuantiteField.getText().trim();

        // String to verify if fields are empty
        boolean isProductDescEmpty = productDesc.isEmpty();
        boolean isProductQantityEmpty = productQantite.isEmpty();
        boolean isProductPriceEmpty = productPrice.isEmpty();
        boolean isAddProductQuantityEmpty = addProductQantity.isEmpty();

        try {
            Connection myConnection = new SqlConnection().getConnection();
            String verifyProduct = "select * from products where productName =?";
            String editProduct = " update products set description=?,quantite=?,prix=? where productName = ?";

            // verify if product is already exist from his name
            PreparedStatement preparedStatement = myConnection.prepareStatement(verifyProduct);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && !isProductDescEmpty && !isProductQantityEmpty && !isProductPriceEmpty && !isAddProductQuantityEmpty) {

                PreparedStatement preparedStmt = myConnection.prepareStatement(editProduct);
                preparedStmt.setString(1, productDesc);
                preparedStmt.setInt(2, Integer.parseInt(productQantite)+Integer.parseInt(addProductQantity));
                preparedStmt.setDouble(3, Float.parseFloat(productPrice));
                preparedStmt.setString(4, productName);

                // execute the prepared statement
                    preparedStmt.executeUpdate();

                    // clear the fields after successfully edit a product info
                    this.editProduct.nameField.setText("");
                    this.editProduct.descriptionField.setText("");
                    this.editProduct.quantiteField.setText("");
                    this.editProduct.priceField.setText("");
                    this.editProduct.addQuantiteField.setText("");
                    System.out.println("successfully edited");


                // Todo: Add msg in screen
            }else {
                // Todo: Add msg in screen
                System.out.println("error product info not edited");


            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}

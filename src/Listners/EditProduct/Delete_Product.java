package Listners.EditProduct;

import Databases.SqlConnection;
import pages.EditProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete_Product implements ActionListener {

    EditProduct editProduct;

    public Delete_Product(EditProduct e) {
        editProduct = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String productname = editProduct.nameField.getText().trim().toUpperCase();
        String productdesc = editProduct.descriptionField.getText().trim().toLowerCase();
        String productQuantite = editProduct.quantiteField.getText().trim().toLowerCase();
        String productPrice = editProduct.priceField.getText().trim();
        try {
            Connection connection = new SqlConnection().getConnection();
            String delete = "delete from products where productName=? and description=? and quantite=? and prix=?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, productname);
            preparedStatement.setString(2, productdesc);
            preparedStatement.setInt(3, Integer.parseInt(productQuantite));
            preparedStatement.setDouble(4, Float.parseFloat(productPrice));
            int resultSet = preparedStatement.executeUpdate();
            if (resultSet == 0) {
                System.out.println("deleted unsuccessfully");
                // todo:add screen msg

            } else {
                // todo : add screen msg
                preparedStatement.executeUpdate();
                // clear the fields after successfully delete a product
                this.editProduct.nameField.setText("");
                this.editProduct.descriptionField.setText("");
                this.editProduct.quantiteField.setText("");
                this.editProduct.priceField.setText("");
                System.out.println("deleted successfully");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

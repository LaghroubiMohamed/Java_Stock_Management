package Listners.AddProduct;

import Databases.SqlConnection;
import pages.AddProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Add_product_save_button implements ActionListener {

 AddProduct addProduct;


    public Add_product_save_button(AddProduct s) {
        addProduct =s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //get data from Add product
        String productName = addProduct.productNameField.getText().trim().toUpperCase();
        String productDesc = addProduct.descriptionField.getText().trim().toLowerCase();
        String productQuantite = addProduct.quantiteField.getText().trim().toLowerCase();
        float productPrix = Float.parseFloat(addProduct.prixField.getText());
        String productExDate = addProduct.dateField.getText().trim();

        //String to verify if fields are empty
        boolean isProductNameEmpty = productName.isEmpty();
        boolean isProductDescEmpty = productDesc.isEmpty();
        boolean isProductQantiteEmpty = productQuantite.isEmpty();
        boolean isExDateEmpty = productExDate.isEmpty();



        try {
           Connection myConnection = new SqlConnection().getConnection();
            String verifyStudent = "select * from products where productName =?";
            String addStudent = " insert into products (productName,description,quantite,prix,date)" + " values (?,?,?,?,?)";

            //verify if product is already exist from his name
            PreparedStatement preparedStatement = myConnection.prepareStatement(verifyStudent);
            preparedStatement.setString(1,productName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                //Todo: add message in screen user can see
                System.out.println("product is already exist");
            }else {
                if (!isProductNameEmpty && !isProductDescEmpty && !isProductQantiteEmpty  && !isExDateEmpty ){

                    System.out.println("product is not exist");
                    PreparedStatement preparedStmt = myConnection.prepareStatement(addStudent);
                    preparedStmt.setString (1, productName);
                    preparedStmt.setString (2, productDesc);
                    preparedStmt.setString (3, productQuantite);
                    preparedStmt.setString(5, productExDate);
                    preparedStmt.setFloat(4,productPrix);
                    // execute the prepared statement
                    preparedStmt.execute();

                    //clear the fields after successfully add a product
                    this.addProduct.productNameField.setText("");
                    this.addProduct.descriptionField.setText("");
                    this.addProduct.quantiteField.setText("");
                    this.addProduct.prixField.setText("");
                    System.out.println("successfully added");
                }else {
                    //Todo: add msg user can see said make sure all the field are not empty
                    System.out.println("fields are empty");
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
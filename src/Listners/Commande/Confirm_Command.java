package Listners.Commande;

import Databases.SqlConnection;
import pages.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Confirm_Command implements ActionListener {

    Commande commande;
    public Confirm_Command(Commande c){
        commande=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            //set data into varibles
            int QuantityLeft = Integer.parseInt(commande.Qantityleft);
            String clientName = commande.getCommandClient.getText().trim();
            String productName = commande.productNameLabel.getText().trim();
            int commandQuantity = Integer.parseInt(commande.productQuantity.getText().trim());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);

            //first get the text from field than remove the last two characther ('dh')
            String productPriceString = commande.productPrice.getText().trim();
            String productTotalPriceString = commande.priceToPay.getText().trim();
            double totalPrice = Double.parseDouble(productTotalPriceString.substring(0,productTotalPriceString.length()-2));
            double productPrice = Double.parseDouble(productPriceString.substring(0,productPriceString.length()-2));

            System.out.println(clientName +" "+productName+" "+commandQuantity+" "+productPrice+" "+totalPrice+" "+date);

            Connection connection = new SqlConnection().getConnection();
            //set data into data base
            String addCommand = " insert into command (client,produit,quantite,prix,prix_total,date)" + " values (?,?,?,?,?,?)";
            String editProductQuantity = " update products set quantite=? where productName = ?";

            if (!clientName.equals("") ){

                PreparedStatement preparedStmt = connection.prepareStatement(addCommand);
                preparedStmt.setString (1, clientName);
                preparedStmt.setString (2, productName);
                preparedStmt.setInt (3, commandQuantity);
                preparedStmt.setDouble(4, productPrice);
                preparedStmt.setDouble(5,totalPrice);
                preparedStmt.setString(6,date);

                //update quantity
                PreparedStatement preparedStatement = connection.prepareStatement(editProductQuantity);
                preparedStatement.setInt(1, QuantityLeft);
                preparedStatement.setString(2, productName);


                // execute the prepared statement
                preparedStatement.executeUpdate();
                preparedStmt.execute();





                //make fields hide again
                commande.labelbordered.setVisible(false);
                commande.factureProName.setVisible(false);
                commande.productNameLabel.setVisible(false);
                commande.factureProPrice.setVisible(false);
                commande.productPrice.setVisible(false);
                commande.factureProQuantity.setVisible(false);
                commande.productQuantity.setVisible(false);
                commande.factureTotalPrice.setVisible(false);
                commande.priceToPay.setVisible(false);
                commande.passCommand.setVisible(false);
                commande.commandClient.setVisible(false);
                commande.getCommandClient.setVisible(false);
                System.out.println("successfully added");
                //clear fields
                commande.quantiteField.setText("");
                commande.clientfield.setText("");
            }else {
                //Todo: add msg user can see said make sure all the field are not empty
                System.out.println("fields are empty");
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

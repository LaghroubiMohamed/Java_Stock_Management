package Listners.Commande;

import Databases.SqlConnection;
import pages.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Show_Facture implements ActionListener {

    Commande commande;
    public Show_Facture(Commande c){
        commande=c;
    }
    public  Show_Facture(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) commande.productName.getSelectedItem();
        String getQuantitefromframe = commande.quantiteField.getText().trim();
        String clientName = commande.clientfield.getText().trim();

            try
            {
                int subQuantity = Integer.parseInt(getQuantitefromframe);

                        try {
                            Connection myConnection = new SqlConnection().getConnection();
                            String selectedProduct = "select * from products where productName =?";
                            //todo: print the current quantite for the selected item
                            PreparedStatement preparedStatement = myConnection.prepareStatement(selectedProduct);
                            preparedStatement.setString(1, selectedItem);
                            ResultSet resultSet = preparedStatement.executeQuery();


                            if (resultSet.next()){
                                String currentProductQuantity = resultSet.getString("quantite");
                                double price = resultSet.getDouble("prix");
                                String proname = resultSet.getString("productName");

                                System.out.println(price);
                                int CPQ = Integer.parseInt(currentProductQuantity);

                                if (CPQ>=subQuantity){
                                   //todo : Write the pass Command code
                                    System.out.println("Done");
                                    //make fields visible
                                    commande.labelbordered.setVisible(true);
                                    commande.factureProName.setVisible(true);
                                    commande.productNameLabel.setVisible(true);
                                    commande.factureProPrice.setVisible(true);
                                    commande.productPrice.setVisible(true);
                                    commande.factureProQuantity.setVisible(true);
                                    commande.productQuantity.setVisible(true);
                                    commande.factureTotalPrice.setVisible(true);
                                    commande.priceToPay.setVisible(true);
                                    commande.passCommand.setVisible(true);
                                    commande.commandClient.setVisible(true);
                                    commande.getCommandClient.setVisible(true);




                                    //pass the left quantity to a string in the command page
                                    commande.Qantityleft = String.valueOf(CPQ-subQuantity);

                                    //total price
                                    float totalprice = (float) (price*subQuantity);

                                    //pass data into the labels
                                    commande.getCommandClient.setText(clientName);
                                    commande.productNameLabel.setText(proname);
                                    commande.productPrice.setText(String.valueOf(price)+" dh");
                                    commande.productQuantity.setText(String.valueOf(subQuantity));
                                    commande.priceToPay.setText(String.valueOf(totalprice)+" dh");


                                    System.out.println("total price = "+ totalprice);

                                }else {
                                    //todo show this msg
                                    System.out.println("this Quantity is not available there is only "+CPQ+" left");
                                }
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
            } catch (NumberFormatException ex)
            {
                //todo: show this msg
                System.out.println("check if the field is not empty end the data entry is a number");
            }
    }
}

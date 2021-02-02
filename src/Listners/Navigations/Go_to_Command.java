package Listners.Navigations;

import Databases.SqlConnection;
import pages.Commande;
import pages.Decision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Go_to_Command implements ActionListener {
    Decision decision;
    public Go_to_Command(Decision d) {
        decision=d;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> combodata = new ArrayList<>();
        try {
            Connection connection = new SqlConnection().getConnection();
            String verifyProduct = "select productName from products ";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(verifyProduct);
            while (resultSet.next()){
               String data = resultSet.getString("productName");
                combodata.add(data);
            }
            if (combodata.isEmpty()){
                //!todo show thid msg for user
                System.out.println("No product is available now ");
            }else {
                Commande commande = new Commande(combodata);
                commande.setVisible(true);
                decision.dispose();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}

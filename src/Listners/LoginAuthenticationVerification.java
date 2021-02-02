package Listners;

import Databases.SqlConnection;
import pages.Accueil;
import pages.Decision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

public class LoginAuthenticationVerification implements ActionListener {
    Accueil accueil;

    public LoginAuthenticationVerification(Accueil a) {
        accueil = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String loginInput = accueil.loginField.getText();
        String passInput = accueil.passwordField.getText();
        try {
            Connection myConnection = new SqlConnection().getConnection();
            String sql = "SELECT * FROM admin where login=? and password=?";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setString(1, loginInput);
            ps.setString(2, passInput);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Decision decision = new Decision();
                decision.setVisible(true);
                System.out.println("login succesfully ");
                accueil.dispose();
            } else {
                System.out.println("Failed");
                accueil.errorMsg.setVisible(true);
                this.accueil.passwordField.setText("");
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}

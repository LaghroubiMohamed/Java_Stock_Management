package pages;

import Listners.LoginAuthenticationVerification;

import java.awt.*;
// import java.awt.image.BufferedImage;
// import java.io.File;
import java.io.IOException;
// import javax.imageio.ImageIO;
import javax.swing.*;

public class Accueil extends JFrame {


    private static final long serialVersionUID = 1L;
    public JTextField loginField;
    public JPasswordField passwordField;
    public JLabel errorMsg;

    public Accueil() throws IOException {
        setTitle("--Login--");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // make the frame half the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width / 2, height / 2);

        // center the jframe on screen
        setLocationRelativeTo(null);

        // login label
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(250, 150, 50, 30);
        loginLabel.setForeground(Color.black);
        getContentPane().setLayout(null);
        getContentPane().add(loginLabel);

        // password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(250, 170, 100, 80);
        passwordLabel.setForeground(Color.black);
        getContentPane().setLayout(null);
        getContentPane().add(passwordLabel);

        // login field
        loginField = new JTextField();
        loginField.setBounds(340, 150, 140, 25);
        getContentPane().setLayout(null);
        getContentPane().add(loginField);

        // password field
        passwordField = new JPasswordField();
        passwordField.setBounds(340, 200, 140, 25);
        getContentPane().setLayout(null);
        getContentPane().add(passwordField);

        // authentification error msg
        errorMsg = new JLabel("authentification échouée ...");
        errorMsg.setBounds(340, 230, 200, 25);
        getContentPane().setLayout(null);
        getContentPane().add(errorMsg);
        errorMsg.setForeground(Color.red);
        errorMsg.setVisible(false);

        // login button
        JButton loginButton;
        loginButton = new JButton("Log In");
        loginButton.setBounds(375, 250, 130, 30);
        loginButton.addActionListener(new LoginAuthenticationVerification(this));
        getContentPane().setLayout(null);
        getContentPane().add(loginButton);

    }

}

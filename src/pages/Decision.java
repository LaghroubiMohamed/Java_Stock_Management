package pages;

import Listners.Navigations.Go_to_AddProduct;
import Listners.Navigations.Go_to_Command;
import Listners.Navigations.Go_to_EditProduct;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Decision extends JFrame {


    private static final long serialVersionUID = 1L;
    public Decision() throws IOException {

        setTitle(" Where to ");
        // make the frame half the height and width
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        setSize(width / 2, height / 2);

        // center the jframe on screen
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        // add  image to the decision page
        String path = "src/images/intro.png";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        Image scaled = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaled));
        label.setBounds(160, 10, 400, 300);
        getContentPane().add(label);

        JButton addButton = new JButton("Add New Product");
        addButton.setBounds(130, 320, 200, 25);
        addButton.setForeground(Color.black);
        addButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(addButton);
        addButton.setBackground(new Color(159, 226, 191));
        addButton.addActionListener(new Go_to_AddProduct(this));

        JButton editButton = new JButton("Edit Products Info");
        editButton.setBounds(350, 320, 200, 25);
        editButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(editButton);
        editButton.setBackground(new Color(218, 247, 166));
        editButton.addActionListener(new Go_to_EditProduct(this));

        JButton CommandButton = new JButton("Pass Command");
        CommandButton.setBounds(570, 320, 200, 25);
        CommandButton.setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(CommandButton);
        CommandButton.setBackground(new Color(229, 204, 255));
        CommandButton.addActionListener(new Go_to_Command(this));


        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(350, 370, 200, 25);
        exitButton.setVisible(true);
        getContentPane().add(exitButton);
        exitButton.setBackground(Color.red);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}

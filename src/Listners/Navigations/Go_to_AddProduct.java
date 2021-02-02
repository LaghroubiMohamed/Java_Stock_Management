package Listners.Navigations;

import pages.AddProduct;
import pages.Decision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Go_to_AddProduct implements ActionListener{

    Decision decision;
    public Go_to_AddProduct(Decision d) {
        decision=d;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AddProduct addProduct = null;
        try {
            addProduct = new AddProduct();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        addProduct.setVisible(true);

        decision.dispose();


    }
}

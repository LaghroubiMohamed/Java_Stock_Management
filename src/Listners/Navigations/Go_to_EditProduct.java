package Listners.Navigations;

import pages.Decision;
import pages.EditProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Go_to_EditProduct implements ActionListener {

    Decision decision;
    public Go_to_EditProduct(Decision d) {
        decision=d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            EditProduct editProduct = new EditProduct();
            editProduct.setVisible(true);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        decision.dispose();


    }
}

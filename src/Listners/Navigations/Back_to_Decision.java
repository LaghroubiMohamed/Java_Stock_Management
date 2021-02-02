package Listners.Navigations;


import pages.AddProduct;
import pages.Commande;
import pages.Decision;
import pages.EditProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Back_to_Decision implements ActionListener {


    AddProduct addProduct;
    public  Back_to_Decision(AddProduct a) throws IOException {
        addProduct =a;


    }

    EditProduct editProduct;
    public Back_to_Decision(EditProduct e) {
        editProduct =e;
    }


    Commande commande;
    public Back_to_Decision(Commande c){
        commande=c;}

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            Decision decision = new Decision();
            decision.setVisible(true);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }



        if ( addProduct != null && addProduct.isVisible() ){
            addProduct.dispose();
        }
        else if (editProduct!=null && editProduct.isVisible()) {
            editProduct.dispose();
        }else commande.dispose();
    }
}

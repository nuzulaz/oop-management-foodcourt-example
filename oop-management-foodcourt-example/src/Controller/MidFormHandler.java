/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import java.awt.event.ActionListener;
import View.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 *
 * @author nuzul
 */
public class MidFormHandler implements ActionListener {
    private MidForm A;
    public MidFormHandler() {
        A = new MidForm();
        A.setVisible(true);
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(A.getBtnFoodcourt())){
            new HandlerTambahFoodcourt();
            A.dispose();
        }else if(source.equals(A.getBtnBack())){
            new HandlerAdminForm();
            A.dispose();
        }else if(source.equals(A.getBtnRestaurant())){
            new RestaurantHandler();
            A.dispose();
        }else if(source.equals(A.getBtnMakanan())){
            new HandlerTambahMakanan();
            A.dispose();
        }else if(source.equals(A.getBtnKurir())){
            new HandlerTambahKurir();
            A.dispose();
        }
    }
    
}

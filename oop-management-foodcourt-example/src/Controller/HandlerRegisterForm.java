/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Controller.CustomerFormHandler;
import Model.pelanggan;
import Model.pelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class HandlerRegisterForm implements ActionListener {
    private RegisterCustomer A;

    public HandlerRegisterForm() {
        A = new RegisterCustomer();
        A.setVisible(true);
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(A.getBtnSubmit())){
            pelanggan p = new pelanggan();
            p.setId_cust(A.getTfId().getText());
            p.setNama(A.getTfNama().getText());
            p.setPassword(A.getTfPassword().getText());
            p.setUsername(A.getTfUsername().getText());
            p.savePelanggan();
        }else if(source.equals(A.getBtnBack())){
            new CustomerFormHandler();
            A.dispose();
        }
    }
    
    
//    public static void main(String[] args) {
//        new HandlerRegisterForm();
//    }
  
}








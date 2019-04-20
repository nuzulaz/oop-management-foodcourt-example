/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.BookingFormHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import View.*;
import Model.pelanggan;

/**
 *
 * @author ASUs
 */
public class CustomerFormHandler implements ActionListener{
    private Customer_Form C;
    ArrayList<pelanggan> listPel = new ArrayList<pelanggan>();
    
    public CustomerFormHandler() {
        C = new Customer_Form();
        C.setVisible(true);
        C.addActionListener(this);
        C.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        boolean cek = false;
        if(source.equals(C.getBtnLogin())){ 
            pelanggan p = new pelanggan();
            listPel = p.LoadPeltoList();
            for (pelanggan x : listPel) {
                if(x.cekPassword(C.getUsername().getText(), C.getPassword().getText())){
                    cek = true;
                }
            }
            if(cek){
                new BookingFormHandler(C.getUsername().getText());
                C.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "SALAH PASSWORD");
            }
        }else if(source.equals(C.getBtnRegister())){
            new HandlerRegisterForm();
            C.dispose();
        }else if(source.equals(C.getBtnBck())){
            new HandlerLoginForm();
            C.dispose();
        }
    }
    
}

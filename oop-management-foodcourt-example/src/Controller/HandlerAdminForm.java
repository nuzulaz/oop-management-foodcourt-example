/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/**
 *
 * @author nuzul
 */
import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HandlerAdminForm extends MouseAdapter implements ActionListener{
   
    private AdminForm A;
    private String id,password;
    public HandlerAdminForm(){
        A = new AdminForm();
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
        A.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source.equals(A.getBtnLogin())){
              Admin ad = new Admin(A.getTfUserName(),A.getTfPassword());
              if(ad.cekPassword("admin","admin")){
                   new MidFormHandler();
                   A.dispose();
              }else{
                  JOptionPane.showMessageDialog(null, "Invalid Login Detail", "Login Error", JOptionPane.ERROR_MESSAGE);
              }
        }else if(source.equals(A.getBtnKembali())){
                new HandlerLoginForm();
                A.dispose();
        }
    }
      
}

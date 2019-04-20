package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import View.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuzul
 */
public class HandlerLoginForm implements ActionListener {
    private LoginForm A;
    
    public HandlerLoginForm(){
        A = new LoginForm();
        A.setVisible(true);
        A.addActionListener(this);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
         if(source.equals(A.getBtnAdmin())){
            new HandlerAdminForm();
            A.dispose();
         }else if(source.equals(A.getBtnCustomer())){
             new CustomerFormHandler();
             A.dispose();
         }
    }
    
}

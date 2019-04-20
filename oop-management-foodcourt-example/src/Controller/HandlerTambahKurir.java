/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.*;
import View.*;
/**
 *
 * @author MIFTAH
 */
public class HandlerTambahKurir extends MouseAdapter implements ActionListener{
    private TambahKurir A;
    
    public HandlerTambahKurir(){
        Kurir x = new Kurir();
        ArrayList<Kurir> listKurir = x.LoadKurirtoList();
        A = new TambahKurir();
        A.setVisible(true);
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(A.getBtnBack())){
            new MidFormHandler();
            A.dispose();
        }else if (source.equals(A.getBtnAdd())){
            String nama = A.getTfName().getText();
            Kurir k = new Kurir(nama);
            System.out.println(k.getNama());
            k.setAge(Integer.parseInt(A.getTfAge().getText()));
            k.setGender(A.getcbGender());
            k.setAddress(A.getTfAddress().getText());
            k.saveKurir();
        }else if(source.equals(A.getBtnView())){
            Database db = new Database();
                          ResultSet rs = null;
                          try{
                              int i = 0;
                              rs = db.getData("select *from tablekurir");
                              while(rs.next()){
                                  A.getOutput().setValueAt(rs.getString("nama"), i, 0);
                                  A.getOutput().setValueAt(rs.getString("age"), i, 1);
                                  A.getOutput().setValueAt(rs.getString("gender"), i, 2);
                                  A.getOutput().setValueAt(rs.getString("Address"), i, 3);
                                  i++;
                              }
                              rs.close();
                          }catch(Exception ae){
                              JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
                          }
        }
    }
    public static void main(String[] args) {
        new HandlerTambahKurir();
    }
}

    


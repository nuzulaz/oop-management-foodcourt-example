package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import View.*;
import Model.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuzul
 */
public class HandlerTambahFoodcourt extends MouseAdapter implements ActionListener{
    private TambahDataFoodcourtForm A;
    private ArrayList<Admin> listAdmin = new ArrayList<Admin>();
                          
    
    public HandlerTambahFoodcourt() {
        A = new TambahDataFoodcourtForm();
        Admin ad = new Admin();
        listAdmin = ad.loadAdmin();
        A.setTfSelamatDatang(listAdmin.get(0).getId());
        A.setVisible(true);
        A.addActionListener(this);
        A.setLocationRelativeTo(null);
        
    
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source.equals(A.getBtnBack())){
                new MidFormHandler();
                A.dispose();
            }else if(source.equals(A.getBtnAdd())){
                        if(!A.getTfNama().getText().equals("") && !A.getTfLocation().getText().equals("") && !A.getTfID().equals("") ){
                              String nama = A.getTfNama().getText();
                              String lokasi = A.getTfLocation().getText();  
                              String id = A.getTfID().getText();
                              Foodcourt fc = new Foodcourt(nama,lokasi,id);
                              if(fc.cekDuplicateFoodcourt(id)){
                                  JOptionPane.showMessageDialog(null, "ID TELAH DIINPUTKAN"); 
                              }else{
                                   fc.saveFoodcourt();
                              }
                        }else{
                              JOptionPane.showMessageDialog(null, "Harus Mengisi Semua Slot");  
                        }
                        
            }else if(source.equals(A.getBtnView())){
                          Database db = new Database();
                          ResultSet rs = null;
                          try{
                              int i = 0;
                              rs = db.getData("select *from foodcourt_tabel");
                              while(rs.next()){
                                  A.getOutput().setValueAt(rs.getString("id_foodcourt"), i, 0);
                                  A.getOutput().setValueAt(rs.getString("nama"), i, 1);
                                  A.getOutput().setValueAt(rs.getString("lokasi"), i, 2);
                                  i++;
                              }
                              rs.close();
                          }catch(Exception ae){
                              JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
                          }
            }
    }
    
}
    

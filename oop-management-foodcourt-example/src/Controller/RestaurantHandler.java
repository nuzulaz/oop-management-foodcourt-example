/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nuzul
 */
public class RestaurantHandler implements ActionListener {
    private TambahRestaurantForm A;
    private ArrayList<Foodcourt> listFood = new ArrayList<Foodcourt>();

    public RestaurantHandler() {
        Foodcourt f = new Foodcourt();
        listFood = f.loadFoodcourt();
        A = new TambahRestaurantForm();
        A.setCbFoodcourtName(listFood);
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
            String nama = A.getTfNama().getText();
            String noResto = A.getTfNoResto().getText();
            String Status = A.getCbStatus();
            if(!A.getTfFoodcourt().equals("") && !A.getTfNama().equals("") && !A.getTfNoResto().equals("")){
                Foodcourt f = new Foodcourt();
                int idx = f.cekFoodcourt(A.getCbFoodcourtName());
                    if(idx!=-1){
                            String foodcourt = listFood.get(idx).getIdFoodcourt();
                            Toko t = new Toko(nama,Status,noResto,foodcourt);
                            if(t.cekDuplicateRestaurant(noResto)){
                                 listFood.get(idx).addToko(t);
                                 t.saveToko();                               
                            } else{
                                JOptionPane.showMessageDialog(null, "ID telah digunakan");
                            }
                    }else{
                        JOptionPane.showMessageDialog(null, "Foodcourt Tidak Ditemukan");
                    }
            }else{
                JOptionPane.showMessageDialog(null,"SEMUA TABEL HARUS TERISI");
            }
        }else if(source.equals(A.getBtnView())){          
                Database db = new Database();
                ResultSet rs = null;
                try{
                    int i = 0;
                    rs = db.getData("select *from restaurant_tabel");
                    while(rs.next()){
                        A.getOutput().setValueAt(rs.getString("nama"), i, 0);
                        A.getOutput().setValueAt(rs.getString("noToko"), i, 1);
                        A.getOutput().setValueAt(rs.getString("id_foodcourt"), i, 2);
                        A.getOutput().setValueAt(rs.getString("status"), i, 3);
                        i++;
                    }
                    rs.close();
                }catch(Exception ae){
                    JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
                }
                try{
                    int i = 0;
                    rs = db.getData("select restaurant_tabel.nama,tablefood.nama,price from restaurant_tabel join tablefood using(noToko)");
                    while(rs.next()){
                        A.getOutputM().setValueAt(rs.getString("restaurant_tabel.nama"), i, 0);
                        A.getOutputM().setValueAt(rs.getString("tablefood.nama"), i, 1);
                        A.getOutputM().setValueAt(rs.getString("price"), i, 2);
                        i++;
                    }
                    rs.close();
                }catch(Exception ae){
                    JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
                }
        }
    }
}

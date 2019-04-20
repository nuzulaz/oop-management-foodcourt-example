/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.*;
import java.util.ArrayList;
import Model.*;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class BookingFormHandler implements ActionListener{
    private BookingMakananForm B;
    private ArrayList<pelanggan> listPel = new ArrayList<pelanggan>();
    private ArrayList<Toko> listTok = new ArrayList<Toko>();
    private int idx = 0;

    public BookingFormHandler() {
    }
    
    public BookingFormHandler(String x) { 
        int i = 0;
        Toko toko = new Toko();
        listTok  = toko.loadToko();
        pelanggan p = new pelanggan();
        listPel = p.LoadPeltoList();
        for(pelanggan d : listPel){
            if(d.getNama().equals(x)){
               idx = i;
            }
            i++;
        }
        B = new BookingMakananForm();
        B.setCRestaurantName(listTok);
        B.setVisible(true);
        B.addActionListener(this);
        B.setLocationRelativeTo(null);
        B.setTfNamaSukses(listPel.get(idx).getNama());
        B.setTable();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(B.getBookBtn())){
            String namaResto = B.getCbResto();
            String noMeja = B.getNoMeja().getText();
            String idBooking = B.getIdBooking().getText();
            String tglBooking = B.getTanggal().getText();
            Booking b = new Booking();
            b.setNamaRestaurant(B.getCbResto());
            System.out.println(b.getNamaRestaurant());
            b.setIdBooking(B.getIdBooking().getText());
            int j = Integer.parseInt(B.getNoMeja().getText());
            b.setNoMeja(j);
            int i = Integer.parseInt(B.getJmlPengunjung());
            b.setJmlPesan(i); 
            b.setTglBooking(B.getTanggal().getText());
            b.setId_cust(listPel.get(idx).getId_cust());
            System.out.println(tglBooking + "  " + noMeja);
            if(!b.cekDuplicateBooking(tglBooking) && b.cekDuplicateMeja(noMeja)){
                JOptionPane.showMessageDialog(null, "NOOB");
            }else{
                b.saveBooking();
            }
//            ArrayList<Booking> listBooking = b.LoadBooktoList();
//            
//        } else if(source.equals(B.getBtnView())) {
//            Database db = new Database();
//            ResultSet rs = null;
//            try{
//                int i = 0;
//                rs = db.getData("select *from viewbooking");
//                while(rs.next()){
//                    B.getOutput().setValueAt(rs.getString("NamaRestaurant"), i, 0);
//                }
//            }
//            
        }else if(source.equals(B.getBackBtn())){
            new CustomerFormHandler();
            B.dispose();
        }else if(source.equals(B.getBtnPark())){
            new HandlerTambahKendaraan();
            B.dispose();
        }
    }
}


////    ini
//}


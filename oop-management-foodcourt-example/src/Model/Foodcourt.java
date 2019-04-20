/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nuzul
 */
public class Foodcourt{
    private String nama;
    private String lokasi;
    private String idFoodcourt;
    private ArrayList<Toko> arrToko = new ArrayList<Toko>();
    private ArrayList<Parkir> arrParkir = new ArrayList<Parkir>();
    private ArrayList<Kurir> arrKurir = new ArrayList<Kurir>();
   

    public Foodcourt(String nama, String lokasi, String idFoodcourt) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.idFoodcourt = idFoodcourt;
    }

    public Foodcourt() {
    }

    public String getIdFoodcourt() {
        return idFoodcourt;
    }
    
    public ArrayList<Toko> getArrToko() {
        return arrToko;
    }
    public void addToko(Toko p){
        arrToko.add(p);
    }

    public ArrayList<Parkir> getArrParkir() {
        return arrParkir;
    }
    
    public void addParkir(Parkir P){
        arrParkir.add(P);
    }
    
    public void addKurir(Kurir k){
        arrKurir.add(k);
    }
    
    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }
    public Toko getArrToko(int i) {
        return arrToko.get(i);
    }


    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    
    public ArrayList<Foodcourt> loadFoodcourt() {
        try {
            Database db = new Database();
            ArrayList<Foodcourt> listFoodcourt = new ArrayList<>();
            String query = "select * from foodcourt_tabel";
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                Foodcourt g = new Foodcourt(rs.getString("nama"),rs.getString("lokasi"),rs.getString("id_foodcourt"));
                listFoodcourt.add(g);
            }
            return listFoodcourt;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error");
        }
    }
    

    
    public boolean cekDuplicateFoodcourt(String ID) {
        boolean cek = false;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from foodcourt_tabel");
            while(rs.next()){
                if(rs.getString("id_foodcourt").equals(ID)){
                    cek = true;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
    
    
    public int cekFoodcourt(String nama){
        int idx=-1;
        Database db = new Database();
        try{
            int i =0;
            ResultSet rs = null;
            rs = db.getData("select *from foodcourt_tabel");
            while(rs.next()){
                if(rs.getString("nama").equals(nama)){
                    idx = i;
                }
                i++;
            }
            rs.close();
        }catch(Exception e){    
            JOptionPane.showMessageDialog(null, "Error : "+e.getMessage());
        }
        return idx;
    }
      

      public void saveFoodcourt(){
        Database db = new Database();
        String s = "insert into foodcourt_tabel(id_foodcourt,nama,lokasi) values('"+this.idFoodcourt+"','"+this.nama+"','"+this.lokasi+"')";                                 
        db.query(s);
        JOptionPane.showMessageDialog(null, "Insert Sukses");
      }
      
}
    
  

    
  

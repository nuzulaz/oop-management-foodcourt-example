/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nuzul
 */
public class Toko {
    private String nama;
    private String status; // Bisa deliv atau engga, bisa deliv 1,ga bisa deliv 2
    private String noToko;
    private String idFoodcourt;
    private ArrayList<Makanan> listMakanan = new ArrayList<Makanan>();
    private ArrayList<Kurir> listKurir = new ArrayList<Kurir>();

    public Toko(String nama, String status, String noToko, String idFoodcourt) {
        this.nama = nama;
        this.status = status;
        this.noToko = noToko;
        this.idFoodcourt = idFoodcourt;
    }

    public Toko() {
    }
    
    public String getNoToko() {
        return noToko;
    }

    public ArrayList<Makanan> getListMakanan() {
        return listMakanan;
    }

    public ArrayList<Kurir> getListKurir() {
        return listKurir;
    }
    
    public void addMakanan(Makanan m){
        listMakanan.add(m);
    }
    
    public void addKurir(Kurir k){
        listKurir.add(k);
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdFoodcourt() {
        return idFoodcourt;
    }

    public void setIdFoodcourt(String idFoodcourt) {
        this.idFoodcourt = idFoodcourt;
    }

    public void saveToko(){
        Database db = new Database();
        String s = "insert into restaurant_tabel(id_foodcourt,nama,status,noToko) values('"+this.idFoodcourt+"','"+this.nama+"','"+this.status+"','"+this.noToko+"')";                                 
        db.query(s);
        JOptionPane.showMessageDialog(null, "Insert Sukses");
    }
    
    public ArrayList<Toko> loadToko(){
        try {
            Database db = new Database();
            ArrayList<Toko> listToko = new ArrayList<Toko>();
            String query = "select * from restaurant_tabel";
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                Toko t = new Toko(rs.getString("nama"),rs.getString("status"),rs.getString("noToko"),rs.getString("id_foodcourt"));
                listToko.add(t);
            }
            return listToko;
        }catch (Exception e) {
            throw new IllegalArgumentException("Error");
            }
        
    }
    
    
    public int cekRestaurant(String nama){
        int idx=-1;
        Database db = new Database();
        try{
            int i =0;
            ResultSet rs = null;
            rs = db.getData("select *from restaurant_tabel");
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
      
    
    
    public boolean cekDuplicateRestaurant(String noToko) {
        boolean cek = true;
        Database db = new Database();
        try{
            ResultSet rs = null;
            rs = db.getData("select *from restaurant_tabel");
            while(rs.next()){
                if(rs.getString("noToko").equals(noToko)){
                    cek = false;
                }
            }
            rs.close();
        }catch(Exception ae){
            JOptionPane.showMessageDialog(null, "Error : "+ae.getMessage());
        }
            return cek;
    }
    
}
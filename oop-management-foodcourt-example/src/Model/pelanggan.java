/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sasa
 */
public class pelanggan extends user {
    private String username;
    private String password;
    private String id_cust;
    private String nama;
    ArrayList<pelanggan> listPel = new ArrayList<pelanggan>(); 

    public pelanggan(String id,String nama,String username, String password) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.id_cust = id;
    }

    public pelanggan() {
    }
    

    public String getUsername() {
        return username;
    }
    
    public String getId_cust() {
        return id_cust;
    }

    public void setId_cust(String id_cust) {
        this.id_cust = id_cust;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public ArrayList<pelanggan> LoadPeltoList(){
        Database db = new Database();
        try {
            
            ArrayList<pelanggan> listPelanggan = new ArrayList<>();
            ResultSet rs = db.getData("select *from customer"); //ambil dari tabel database
            while (rs.next()) {
                pelanggan p = new pelanggan(rs.getString("id_cust"),rs.getString("nama"),rs.getString("username"),rs.getString("password"));
                listPelanggan.add(p);
            }
        
            return listPelanggan;
        
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }
    
    public void savePelanggan(){
        Database db = new Database();
        String s = "insert into customer(id_cust,nama,username,password) values('"+this.id_cust+"','"+this.nama+"','"+this.username+"','"+this.password+"')";                                 
        db.query(s);
    }
    
    
   @Override
    public boolean cekPassword(String x, String y) {
        boolean cek = false;
        if(this.username.equals(x) && this.password.equals(y)){
                cek = true;
        }
        return cek;
    }
   // public void 
    
}